package org.easymis.workflow.app.controller.form;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "表单字段定义管理 controller", tags = { "表单字段定义管理 操作接口" })
@RequestMapping("/bpm/form/field")
public class BpmFormFieldController {

}
