package org.easymis.workflow.app.controller.activiti;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Model;
import org.easymis.workflow.app.entity.vo.BpmnInstanceDefineVO;
import org.easymis.workflow.app.service.bpmn.BpmnInstanceDefineService;
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
@Api(value = "正在运行的流程实例controller", tags = { "流程定义操作接口" })
@RequestMapping("/bpmn/instance/bpmDefine")
public class BpmnInstanceDefineController {
    @Autowired
    private BpmnInstanceDefineService service;  
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("bpmn/instance/bpmDefine/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("bpmn/instance/bpmDefine/index");
		return mv;
	}
	//删除流程实例
	@RequestMapping(value = "/remove/{procId}", method = {RequestMethod.DELETE,RequestMethod.GET})
	public RestfulMessage delete(HttpSession httpSession, @PathVariable("procId") String[] procId) {
		httpSession.getAttribute("userLogin");
		if (procId.length > 0) {
			for (int i = 0; i < procId.length; i++) {
				try {
					runtimeService.deleteProcessInstance(procId[i], "");
					historyService.deleteHistoricProcessInstance(procId[i]);
				} catch (Exception e) {
					return new RestfulMessage().success("删除流程实例服务异常");
				}

			}

		}

		return new RestfulMessage().success();
	}
	
	//设置分类
	@RequestMapping("/setCategory/defIds/typeId")
	public ModelAndView  setCategory(HttpSession httpSession,@PathVariable String defIds,@PathVariable String typeId) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("activiti/process/definition/index");
		return mv;
	}
	//导出
	//导入
	//挂起
	//恢复
	//复制
	//设置
	//编辑指南
	//清楚数据
	/**
流程名称、流程业务主键、流程状态、测试状态、创建开始时间、创建结束时间
	 */
	@RequestMapping(value = "/datatable/listJson.json", method = RequestMethod.GET)
	public DataTableResult listJson(HttpServletRequest request,HttpSession httpSession,BpmnInstanceDefineVO vo) {
		return service.findByDataTable(vo);
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public DataTableResult findAll(HttpServletRequest request,HttpSession httpSession,@RequestBody BpmnInstanceDefineVO vo) {
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
		return service.findByDataTable(vo);
	}
}
