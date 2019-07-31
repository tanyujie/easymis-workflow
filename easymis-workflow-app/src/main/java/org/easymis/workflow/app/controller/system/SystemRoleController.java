package org.easymis.workflow.app.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.workflow.app.entity.Role;
import org.easymis.workflow.app.service.RoleService;
import org.easymis.workflow.app.utils.RestfulMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "系统角色controller", tags = { "系统角色操作接口" })
@RequestMapping("/system/role")
public class SystemRoleController {
	@Autowired
	private RoleService service;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/role/index");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/role/index");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public RestfulMessage add(@RequestBody Role bean) {
		try {
			service.save(bean);
			return new RestfulMessage().success("保存角色信息成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存角色信息失败");
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestfulMessage update(HttpSession httpSession,@RequestBody Role bean) {
		try {
			service.update(bean);
			return new RestfulMessage().success("保存角色信息成功");
		} catch (Exception e) {
			return new RestfulMessage().success("保存角色信息失败");
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.PUT)
	public RestfulMessage get(HttpSession httpSession, @PathVariable String id) {
		try {
			service.findById(id);
			return new RestfulMessage().success("刪除角色信息成功");
		} catch (Exception e) {
			return new RestfulMessage().success("刪除角色信息失败");
		}
	}
	@ApiOperation(value = "批量删除角色", notes = "批量删除角色")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public RestfulMessage deleteAllById(@RequestBody String[] ids){
		try {
			if(null == ids || 0 > ids.length){
				return RestfulMessage.failure("参数不全");
			}
			return RestfulMessage.success(service.delete(ids));
		}catch (Exception e){
			return RestfulMessage.failure("删除失败");
		}
	}
	@ApiOperation(value = "获取角色列表", notes = "获取角色列表")
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public RestfulMessage getList() {
		try {
			List<Role>  list = service.findAll();
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取角色列表失败");
		}

	}
	@ApiOperation(value = "获取角色分页列表", notes = "获取角色分页列表")
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public RestfulMessage getPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		try {
			PageInfo<Role> list = service.getPage(pageNum, pageSize);
			return new RestfulMessage().success(list);
		} catch (Exception e) {
			return new RestfulMessage().success("获取角色列表失败");
		}

	}
	@RequestMapping("/test")
	public String test() {
		return ("程序逻辑返回");
	}
}
