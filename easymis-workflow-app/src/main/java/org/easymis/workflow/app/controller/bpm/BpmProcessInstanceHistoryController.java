package org.easymis.workflow.app.controller.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "流程实例历史记录controller", tags = { "流程实例实例历史记录操作接口" })
@RequestMapping("/bpm/process/instance/history")
public class BpmProcessInstanceHistoryController {

}
