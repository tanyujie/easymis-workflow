package org.easymis.workflow.app.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "系统角色controller", tags = { "系统角色操作接口" })
@RequestMapping("/system/role")
public class SystemRoleController {
    @Autowired
    private RoleService roleService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/role/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/role/index");
		return mv;
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public boolean add(@RequestBody Role bean) {
		return roleService.save(bean);
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Role> findAll(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return roleService.findAll();
	}
    @RequestMapping("/test")
    public String test() {
        return ("程序逻辑返回");
    }
}
