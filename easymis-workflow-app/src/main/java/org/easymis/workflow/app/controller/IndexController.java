package org.easymis.workflow.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@Controller
@Api(value = "系统首页controller", tags = { "系统首页操作接口" })
public class IndexController {
	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@RequestMapping("index")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/index.html")
	public String index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "index";
	}

	@RequestMapping("/main.html")
	public String main(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "main";
	}

	@RequestMapping("/403")
	public String f(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "403";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
