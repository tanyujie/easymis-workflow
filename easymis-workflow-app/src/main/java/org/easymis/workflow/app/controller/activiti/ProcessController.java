package org.easymis.workflow.app.controller.activiti;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.vo.BaseForm;
import org.easymis.workflow.app.entity.vo.UserVO;
import org.easymis.workflow.app.service.ProcessService;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "流程处理controller", tags = { "流程处理操作接口" })
@RequestMapping("/activiti/process")
public class ProcessController {
	@Autowired
	private ProcessService processService;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/index");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/index");
		return mv;
	}
	@RequestMapping("/listTask.html")
	public ModelAndView listTask(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/listTask");
		return mv;
	}
	// 读取登录用户的全部申请
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public DataTableResult listProcessInstance(HttpServletRequest request, HttpSession session, String processType) {
		int start = Integer.parseInt(request.getParameter("start"));
		int rows = Integer.parseInt(request.getParameter("length"));

		HashMap<String, Object> map = new HashMap<String, Object>();
		int page = 1;
		if (start == 0) {
			page = 1;
		} else {
			page = start / rows + 1;
		}

		DataTableResult result = new DataTableResult();
		// 从session中拿回登录的用户
		UserVO user=(UserVO)session.getAttribute("workflowUser");
		// 获取流程类型
		if (BaseForm.VACATION.equals(processType)) {
			result = processService.listVacation(user.getWorkflowUserId(), page, rows);
		} else if (BaseForm.EXPENSE.equals(processType)) {
			// this.processes = this.processService.listExpenseAccount(user.getId());
		} else if (BaseForm.SALARY.equals(processType)) {
			// this.processes = this.processService.listSalaryAdjust(user.getId());
		}
		return result;
	}
	// 显示流程图
	@RequestMapping(value = "/showDiagram", method = RequestMethod.GET)
	public String showDiagram(HttpServletResponse response,String processInstanceId) {
		OutputStream out = null;
		try {
			InputStream is = processService.getDiagram(processInstanceId);
			response.setContentType("multipart/form-data;charset=utf8");
            out = response.getOutputStream();
            out.write(getImgByte(is));
            out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
		return null;
	}
	// 将输入流转换为byte数组
	private byte[] getImgByte(InputStream is) throws IOException {	
		
        BufferedInputStream bufin = new BufferedInputStream(is);  
        int buffSize = 1024;  
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize); 
  
        byte[] temp = new byte[buffSize];  
        int size = 0;  
        while ((size = bufin.read(temp)) != -1) {  
            out.write(temp, 0, size);  
        }  
        bufin.close();  
        is.close();  
        byte[] content = out.toByteArray();  
        out.close();  
        return content; 
	}
}
