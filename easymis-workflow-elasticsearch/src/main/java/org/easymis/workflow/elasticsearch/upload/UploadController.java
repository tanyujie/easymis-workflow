package org.easymis.workflow.elasticsearch.upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description:
 * @author: ztd
 * @date 2019/6/17 下午2:56
 */
@RequestMapping("/api")
@RestController
@Api(value = "语料信息controller", tags = { "语料信息操作接口" })
public class UploadController {
	@Autowired
	private UploadClient client;
    /**
     * 单个文件上传
     * @param type
     * @param file
     * @return
     */
    @PostMapping(value ="/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestParam(value = "type", required = false) String type,
                           @RequestPart(value="file", required = false)MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "成功！";
    }

    /**
     * 多个文件上传
     * @param type
     * @param files
     * @return
     */
	@ApiOperation(value = "多条件查询项目列表", notes = "多条件查询项目列表")
    @PostMapping(value ="/multiUpload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String multiUpload(@RequestParam(value = "type", required = false) String type,
                                @RequestPart(value="files", required = false)MultipartFile[] files) {
        for (MultipartFile file : files) {
            //System.out.println(file.getOriginalFilename());
        }
        System.out.println(client.multiUpload(type, files));
        return "成功！";
    }
}
