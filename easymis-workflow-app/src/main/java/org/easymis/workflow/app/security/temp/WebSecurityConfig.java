package org.easymis.workflow.app.security.temp;

import java.util.Arrays;
import java.util.List;

import org.easymis.workflow.app.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;

/*@Configuration
@EnableWebSecurity*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetialsService userService;

	    //配置拦截策略
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
          // 所有用户均可访问的资源
          .antMatchers( "/resources/**","/static/**","/favicon.ico","/css/**","/common/**","/js/**","/plugins/**","/scss/**","/images/**",
        		  "/captcha.jpg","/login","/login.html","/login.do","/userLogin","/login-error").permitAll()
          //任何尚未匹配的URL只需要验证用户即可访问
          .and()
          .authorizeRequests()
          .anyRequest()
          .authenticated();
/*          .and()
          .formLogin()//开启formLogin默认配置
          .loginPage("/login.html").permitAll()//请求时未登录跳转接口
          .failureUrl("/login/fail")//用户密码错误跳转接口
          .defaultSuccessUrl("/index")//登录成功跳转接口
          .loginProcessingUrl("/login.do")//post登录接口，登录验证由系统实现
		  .usernameParameter("username")	//要认证的用户参数名，默认username
		  .passwordParameter("password")	//要认证的密码参数名，默认password*/

          //权限拒绝的页面
          http.exceptionHandling().accessDeniedPage("/403");
          http
          .formLogin().loginPage("/login")
          .defaultSuccessUrl("/index")
          .failureUrl("/login-error")
          .permitAll();

	    //配置注销
		 http
		  .logout()
		  .logoutUrl("/logout")//注销接口
		  .logoutSuccessUrl("/login").permitAll()//注销成功跳转接口
		  .deleteCookies("myCookie") //删除自定义的cookie
		  .and()
		  .csrf().disable();           //禁用csrf

    }
	   //配置加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
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
    }

}
