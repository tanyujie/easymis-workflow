package org.easymis.workflow.app.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "邮箱用户设置  controller", tags = { "邮箱用户设置 操作接口" })
@RequestMapping("/system/mailConfig")
public class MailConfig {

}
