package org.easymis.workflow.app.controller.activiti;

import javax.servlet.http.HttpSession;

import org.activiti.engine.runtime.ProcessInstance;
import org.easymis.workflow.app.entity.vo.UserVO;
import org.easymis.workflow.app.entity.vo.VacationForm;
import org.easymis.workflow.app.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/activiti/vacation")
@Api(value = "activiti测试工具类controller", tags = { "activiti测试工具类操作接口" })
public class VacationController {
	@Autowired
	private ProcessService processService;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/vacation/index");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/vacation/index");
		return mv;
	}

	@RequestMapping("/apply.html")
	public ModelAndView apply(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		processService.startVacation("");
		//
		ModelAndView mv = new ModelAndView("activiti/vacation/apply");
		return mv;
	}

	// 启动请假流程
	@RequestMapping("/start")
	public boolean startVacation(@RequestBody VacationForm vacationForm,HttpSession session) {
		UserVO user=(UserVO)session.getAttribute("workflowUser");
		vacationForm.setUserId(user.getWorkflowUserId());
		vacationForm.setUserName(user.getUserName());
		ProcessInstance pi = processService.startVacation(vacationForm);
		if (pi != null)
			return true;
		else
			return false;
	}
}
