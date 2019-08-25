package org.easymis.workflow.app.security;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.Permission;
import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.entity.User;
import org.easymis.workflow.app.entity.system.LoginLog;
import org.easymis.workflow.app.mapper.UserMapper;
import org.easymis.workflow.app.service.LoginLogService;
import org.easymis.workflow.app.utils.IPUtils;
import org.easymis.workflow.app.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    @Autowired
    UserMapper userDao;
    @Autowired
    LoginLogService loginLogService;
    @Override
    protected void configure(HttpSecurity http) throws Exception { //配置策略
	      http.authorizeRequests()
          // 所有用户均可访问的资源
          .antMatchers("/resources/**","/static/**","/favicon.ico","/css/**","/common/**","/js/**","/plugins/**","/scss/**","/images/**",
        		  "/captcha.jpg","/login","/login.html","/login.do","/userLogin","/login-error","/swagger-resources","/**").permitAll();
          //任何尚未匹配的URL只需要验证用户即可访问        
/*        http.authorizeRequests()
         .anyRequest()
         .authenticated();*/
        
/*         http
         .formLogin()//开启formLogin默认配置
         .loginPage("/login")//请求时未登录跳转接口
         .defaultSuccessUrl("/index")//登录成功跳转接口
         .failureUrl("/login-error")//用户密码错误跳转接口
         .permitAll()
         .successHandler(loginSuccessHandler());
        //权限拒绝的页面
        http.exceptionHandling().accessDeniedPage("/403");
        
	    //配置注销
		 http
		  .logout()
		  .permitAll()
		  .invalidateHttpSession(true)
		  .logoutUrl("/logout")//注销接口
		  .logoutSuccessUrl("/login").permitAll()//注销成功跳转接口
		  .deleteCookies("JSESSIONID")
		  .logoutSuccessHandler(logoutSuccessHandler())//删除自定义的cookie
		  .and()
		  .sessionManagement()
		  .maximumSessions(10).expiredUrl("/login");*/
		  http.csrf().disable();
	      //配置登录不需要验证
		 http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new PasswordEncoder() {
            //加密
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            //解密,前者是输入的密码,后者是数据库查询的密码
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                try {
                    SecurityUser user = (SecurityUser) authentication.getPrincipal();
                    logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
                } catch (Exception e) {
                    logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
                }
                httpServletResponse.sendRedirect("/login");
            }
        };
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                
                super.onAuthenticationSuccess(request, response, authentication);
                //此处的user是entity包中的user
           	   org.easymis.workflow.app.entity.User user = userDao.findByUsername(userDetails.getUsername());
                if (user != null) {
                    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                    //获取用户的角色集合
                    List<Role> roles = user.getRoles();
                    setUserPermissions(roles);
                    saveWorkflowUser((user.getId()+"").trim());
                    //遍历角色集合，并获取每个角色拥有的权限
                    for (Role role : roles) {
                        List<Permission> permissions = role.getPermissions();

                        for (Permission permission :permissions) {
                            //为每个授权中心对象写入权限名
                            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
                        }
                    }
                    /**此处的user是springsecurity中的一个实现了UserDetails接口的user类，因为我们没有将entity中的user去实现
                     * UserDetails接口，所以只能在此处调用实现好的构造方法
                     */
                    saveLoginLog(user);
                }
            }
        };
    }
    @Bean
    public UserDetailsService userDetailsService() {    //用户登录实现
        return new UserDetailsService() {
            @Autowired
            UserMapper userDao;

            @Override
            public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
                User user = userDao.findByUsername(name);
                if (user == null) throw new UsernameNotFoundException("Username " + name + " not found");
                return new SecurityUser(user);
            }
        };
    }
    //获取用户权限
	private void setUserPermissions(List<Role> roles) {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session=attrs.getRequest().getSession();
		List<Permission> rolesList = new ArrayList<Permission>();
        for (Role role : roles) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission :permissions) {
            	rolesList.add(permission);
            }
        }
        List<Permission> resultList = new ArrayList<>(new HashSet<>(rolesList));
		session.setAttribute("permissions", resultList);

	}
	//保存工作流用户信息
	private void saveWorkflowUser(String userId) {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session=attrs.getRequest().getSession();
		// 将用户放到session中
		session.setAttribute("workflowUser", userDao.getWorkflowUserInfo(userId));
		// 将用户组放到session中
/*		Group group = this.userService.getGroup(user.getId());
		session.setAttribute("workflow-group", group);*/		
	}
	//写登录日志
	private void saveLoginLog(org.easymis.workflow.app.entity.User user) {
		LoginLog bean= new LoginLog();
		bean.setCreator(user.getUsername());
		bean.setLoginType("数据资产平台");
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		bean.setIp(IPUtils.getIpAddr(attrs.getRequest()));
		bean.setDeviceType("web");
		bean.setImei("无");
		bean.setCertifiedResult("成功");
		bean.setDelegateUser("无");
		loginLogService.save(bean);
	}
}