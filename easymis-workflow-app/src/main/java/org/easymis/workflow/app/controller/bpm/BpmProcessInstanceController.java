package org.easymis.workflow.app.controller.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "流程实例controller", tags = { "流程实例操作接口" })
@RequestMapping("/bpm/process/instance")
public class BpmProcessInstanceController {

}
