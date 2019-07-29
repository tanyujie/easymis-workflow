package org.easymis.workflow.app.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
定时计划 
 */

@RestController
@Api(value = "定时计划  controller", tags = { "定时计划  操作接口" })
@RequestMapping("/system/scheduler")
public class SystemScheduler {

}
