package org.easymis.workflow.app.controller.organize;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.organize.OrganizeRole;
import org.easymis.workflow.app.entity.vo.OrganizeRoleVO;
import org.easymis.workflow.app.service.organize.OrganizeRoleService;
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
@Api(value = "角色管理 controller", tags = { "角色管理  操作接口" })
@RequestMapping("/organize/role")
public class OrganizeRoleController {
	@Autowired
	private OrganizeRoleService service;

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
	public RestfulMessage saveCategory(HttpSession httpSession, @RequestBody OrganizeRole bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.save(bean);
			return new RestfulMessage().success("保存角色成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存角色失败");
		}

	}

	// 修改
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public RestfulMessage updateCategory(HttpSession httpSession, @PathVariable("id") String id,
			@RequestBody OrganizeRole bean) {
		try {
			httpSession.getAttribute("userLogin");
			service.update(bean);
			return new RestfulMessage().success("更新角色成功");
		} catch (Exception e) {
			return new RestfulMessage().success("更新角色失败");
		}

	}

	// 获取详情
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public RestfulMessage getCategory(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			OrganizeRole bean = service.get(id);
			return new RestfulMessage().success(bean);
		} catch (Exception e) {
			return new RestfulMessage().success("获取角色失败");
		}

	}

	// 删除
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("id") String id) {
		try {
			httpSession.getAttribute("userLogin");
			service.delete(id);
			return new RestfulMessage().success("删除角色成功");
		} catch (Exception e) {
			return new RestfulMessage().success("删除角色失败");
		}

	}
	@ApiOperation(value = "获取角色列表", notes = "获取角色列表")
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public RestfulMessage getList() {
		try {
			List<OrganizeRole>  list = service.findAll();
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取角色列表失败");
		}

	}
	@ApiOperation(value = "获取角色分页列表", notes = "获取角色分页列表")
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public RestfulMessage getPage(OrganizeRoleVO vo) {
		try {
			PageInfo<OrganizeRole> list = service.findByPage(vo);
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取角色列表失败");
		}

	}
	//
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request, HttpSession httpSession, OrganizeRoleVO vo) {
		return service.findByDataTable(vo);
	}
	//角色权限修改
	@RequestMapping(value = "/updateResource", method = RequestMethod.GET)
	public RestfulMessage updateResource(HttpServletRequest request, HttpSession httpSession, OrganizeRoleVO vo) {
		try {
			httpSession.getAttribute("userLogin");
		    //service.delete(id);
			return new RestfulMessage().success("角色授权成功");
		} catch (Exception e) {
			return new RestfulMessage().success("角色授权失败");
		}

	}
	
	
}
