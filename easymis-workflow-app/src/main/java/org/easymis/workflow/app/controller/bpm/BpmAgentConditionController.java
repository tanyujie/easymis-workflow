package org.easymis.workflow.app.controller.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "流程代理设置controller", tags = { "流程代理设置操作接口" })
@RequestMapping("/bpm/agent/condition")
public class BpmAgentConditionController {

}
