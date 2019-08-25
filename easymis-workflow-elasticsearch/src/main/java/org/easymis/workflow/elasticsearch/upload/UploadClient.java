package org.easymis.workflow.elasticsearch.upload;

import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @author: ztd
 * @date 2019/6/12 下午7:31
 */
@FeignClient(name= "LJ-NLP-PROJECT-RESTAPI-RESTAPI", configuration = UploadClient.FeignSupportConfig.class)
public interface UploadClient {
    /**
     * 单个文件上传
     * @param type
     * @param file
     * @return
     */
    @PostMapping(value ="/api/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestParam(value = "type", required = false) String type,
                           @RequestPart(value="file", required = false)MultipartFile file);

    /**
     * 多个文件上传
     * @param type
     * @param files
     * @return
     */
    @PostMapping(value ="/api/file/multiUpload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String multiUpload(@RequestParam(value = "type", required = false) String type,
                                @RequestPart(value="files", required = false)MultipartFile[] files);

    @Configuration
    class FeignSupportConfig {
        @Bean
        public Encoder encoder(ObjectFactory<HttpMessageConverters> messageConverters) {
            return new FeignSpringFormEncoder(new SpringEncoder(messageConverters)) ;
        }
    }
}
