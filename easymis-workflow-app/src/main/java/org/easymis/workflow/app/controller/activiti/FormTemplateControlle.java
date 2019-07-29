package org.easymis.workflow.app.controller.activiti;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.bpm.FormTemplate;
import org.easymis.workflow.app.entity.vo.FormTemplateVO;
import org.easymis.workflow.app.service.ProcessDefinitionService;
import org.easymis.workflow.app.service.bpmn.FormTemplateService;
import org.easymis.workflow.app.utils.RestfulMessage;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "表单模板controller", tags = { "表单模板操作接口" })
@RequestMapping("/form/template")
public class FormTemplateControlle {
    @Autowired
    private ProcessDefinitionService processDefinitionService;
    @Autowired
    private FormTemplateService service;   
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return mv;
	}
	//保存
	@RequestMapping(value = "/save/", method = RequestMethod.POST)  
	public RestfulMessage saveCategory(HttpSession httpSession, @RequestBody FormTemplate bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.save(bean);
			return new RestfulMessage().success("保存分类成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存分类失败");
		}

	}
	//修改
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)  
	public RestfulMessage  updateCategory(HttpSession httpSession,@PathVariable("id") String id,@RequestBody FormTemplate bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.update(bean);
			return new RestfulMessage().success("更新分类成功");
		} catch (Exception e) {
			return new RestfulMessage().success("更新分类失败");
		}

	}
	//获取详情
	@RequestMapping(value = "/get/{id}",  method = RequestMethod.GET)  
	public RestfulMessage  getCategory(HttpSession httpSession,@PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			FormTemplate bean=service.get(id);
			return new RestfulMessage().success(bean);
		} catch (Exception e) {
			return new RestfulMessage().success("获取分类失败");
		}

	}

	//删除
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			service.delete(id);
			return new RestfulMessage().success("删除分类成功");
		} catch (Exception e) {
			return new RestfulMessage().success("删除分类失败");
		}

	}
	//
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request,HttpSession httpSession,FormTemplateVO vo) {
		return service.findByDataTable(vo);
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
		return processDefinitionService.findAll(map, page, rows);
	}
}
