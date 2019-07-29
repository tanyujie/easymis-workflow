package org.easymis.workflow.app.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "公告管理 controller", tags = { "公告管理  操作接口" })
@RequestMapping("/system/news")
public class NewsController {

}
