package org.easymis.workflow.app.controller.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "任务管理controller", tags = { "任务管理操作接口" })
@RequestMapping("/bpm/task")
public class BpmTaskController {

}
