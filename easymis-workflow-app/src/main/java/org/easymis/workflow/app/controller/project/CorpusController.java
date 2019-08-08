package org.easymis.workflow.app.controller.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "语料库管理controller", tags = { "语料库管理 操作接口" })
@RequestMapping("/corpus")
public class CorpusController {

}
