package org.easymis.workflow.app.mapper.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
/**
 * 流程测试Demo
* @ClassName: MyCustomMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lenovo-t
* @date 2019年6月18日
*
 */
public interface MyCustomMapper {

    @Select("select * from act_ru_task")
    List<Map<String, Object>> findAll();
}