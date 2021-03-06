package org.easymis.workflow.app.controller.activiti;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.service.GroupServiceImpl;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "用户分组controller", tags = { "用户分组操作接口" })
@RequestMapping("/activiti/group")
public class GroupAction {
    @Autowired
    private GroupServiceImpl groupService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/group/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/group/index");
		return mv;
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public DataTableResult findAll(HttpServletRequest request,HttpSession httpSession) {
		int start = Integer.parseInt(request.getParameter("start"));
		int rows = Integer.parseInt(request.getParameter("length"));

		HashMap<String, Object> map = new HashMap<String, Object>();
		int page=1;
		if(start==0) {
			 page=1;
		}else {
			 page=start/rows+1;			
		}
		httpSession.getAttribute("userLogin");
		return groupService.findAll(map, page, rows);
	}
}
