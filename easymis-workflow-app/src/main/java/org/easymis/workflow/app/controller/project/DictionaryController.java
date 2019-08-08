package org.easymis.workflow.app.controller.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "词典管理 -存储用户发现的新词controller", tags = { "词典管理 操作接口" })
@RequestMapping("/dictionary")
public class DictionaryController {

}
