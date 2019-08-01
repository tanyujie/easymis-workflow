package org.easymis.workflow.app.controller.organize;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.organize.OrganizeDepartment;
import org.easymis.workflow.app.entity.organize.OrganizeDepartmentVO;
import org.easymis.workflow.app.service.organize.OrganizeDepartmentService;
import org.easymis.workflow.app.utils.RestfulMessage;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "部门管理 controller", tags = { "部门管理  操作接口" })
@RequestMapping("/organize/department")
public class OrganizeDepartmentController {
	@Autowired
	private OrganizeDepartmentService service;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("organize/role/index");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("organize/role/index");
		return mv;
	}

	// 保存
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public RestfulMessage saveCategory(HttpSession httpSession, @RequestBody OrganizeDepartment bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.save(bean);
			return new RestfulMessage().success("保存部门成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存部门失败");
		}

	}

	// 修改
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public RestfulMessage updateCategory(HttpSession httpSession, @PathVariable("id") String id,
			@RequestBody OrganizeDepartment bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.update(bean);
			return new RestfulMessage().success("更新部门成功");
		} catch (Exception e) {
			return new RestfulMessage().success("更新部门失败");
		}

	}

	// 获取详情
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public RestfulMessage getCategory(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			OrganizeDepartment bean = service.get(id);
			return new RestfulMessage().success(bean);
		} catch (Exception e) {
			return new RestfulMessage().success("获取部门失败");
		}

	}

	// 删除
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			service.delete(id);
			return new RestfulMessage().success("删除部门成功");
		} catch (Exception e) {
			return new RestfulMessage().success("删除部门失败");
		}

	}
	@ApiOperation(value = "获取部门列表", notes = "获取部门列表")
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public RestfulMessage getList() {
		try {
			List<OrganizeDepartment>  list = service.findAll();
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取部门列表失败");
		}

	}
	@ApiOperation(value = "获取部门分页列表", notes = "获取部门分页列表")
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public RestfulMessage getPage(OrganizeDepartmentVO vo) {
		try {
			PageInfo<OrganizeDepartment> list = service.findByPage(vo);
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取部门列表失败");
		}

	}
	//
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request, HttpSession httpSession, OrganizeDepartmentVO vo) {
		return service.findByDataTable(vo);
	}

	
	
}
