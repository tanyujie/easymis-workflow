package org.easymis.workflow.app.controller.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "表单实例数据，表单定义与流程实例的关系管理 controller", tags = { "表单实例数据，表单定义与流程实例的关系管理 操作接口" })
@RequestMapping("/bpm/form/instance")
public class BpmFormInstanceController {

}
