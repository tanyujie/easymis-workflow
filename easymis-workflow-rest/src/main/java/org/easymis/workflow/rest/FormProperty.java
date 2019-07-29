package org.easymis.workflow.rest;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class FormProperty {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = engine.getRepositoryService();
		FormService formService = engine.getFormService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/FormProperty.bpmn").deploy();
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 使用表单参数开始流程
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("userName", "crazyit");
		ProcessInstance pi = formService.submitStartFormData(pd.getId(), vars);
		// 查询参数
		System.out.println(runtimeService.getVariable(pi.getId(), "userName"));
	}

}
