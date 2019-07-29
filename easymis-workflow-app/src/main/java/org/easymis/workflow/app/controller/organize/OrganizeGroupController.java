package org.easymis.workflow.app.controller.organize;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.organize.OrganizeGroup;
import org.easymis.workflow.app.entity.vo.OrganizeGroupVO;
import org.easymis.workflow.app.service.organize.OrganizeGroupService;
import org.easymis.workflow.app.service.organize.OrganizePositionService;
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
@Api(value = "分组管理 controller", tags = { "分组管理  操作接口" })
@RequestMapping("/organize/group")
public class OrganizeGroupController {    
    @Autowired
    private OrganizeGroupService service;   
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("organize/group/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("organize/group/index");
		return mv;
	}
	//保存
	@RequestMapping(value = "/save/", method = RequestMethod.POST)  
	public RestfulMessage saveCategory(HttpSession httpSession, @RequestBody OrganizeGroup bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.save(bean);
			return new RestfulMessage().success("保存分组成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存分组失败");
		}

	}
	//修改
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)  
	public RestfulMessage  updateCategory(HttpSession httpSession,@PathVariable("id") String id,@RequestBody OrganizeGroup bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.update(bean);
			return new RestfulMessage().success("更新分组成功");
		} catch (Exception e) {
			return new RestfulMessage().success("更新分组失败");
		}

	}
	//获取详情
	@RequestMapping(value = "/get/{id}",  method = RequestMethod.GET)  
	public RestfulMessage  getCategory(HttpSession httpSession,@PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			OrganizeGroup bean=service.get(id);
			return new RestfulMessage().success(bean);
		} catch (Exception e) {
			return new RestfulMessage().success("获取分组失败");
		}

	}

	//删除
	@RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			service.delete(id);
			return new RestfulMessage().success("删除分组成功");
		} catch (Exception e) {
			return new RestfulMessage().success("删除分组失败");
		}

	}
	//
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request,HttpSession httpSession,OrganizeGroupVO vo) {
		return service.findByDataTable(vo);
	}}
