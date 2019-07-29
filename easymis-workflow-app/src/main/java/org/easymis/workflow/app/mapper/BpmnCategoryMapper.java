package org.easymis.workflow.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.workflow.app.entity.bpm.BpmnCategory;
import org.easymis.workflow.app.entity.vo.BpmnCategoryVO;
@Mapper
public interface BpmnCategoryMapper {

    @Select("SELECT * FROM ew_bpmn_category WHERE category_id = #{categoryId}")
    BpmnCategory findById(@Param("categoryId") String categoryId);
    @Insert("INSERT INTO ew_bpmn_category(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO ew_bpmn_category(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO ew_bpmn_category(login_log_id, creator_id, creator, login_time, login_type, ip, place, device_type, kernel, platform, IMEI, certified_result, delegate_user) "
    		+ "VALUES(#{loginLogId}, #{creatorId}, #{creator}, #{loginTime}, #{loginType}, #{ip}, #{place}, #{deviceType}, #{kernel}, #{platform}, #{imei}, #{certifiedResult}, #{delegateUser})")
    int insertByBean(BpmnCategory bean);

    @Update("UPDATE ew_bpmn_category leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void updateByBean(BpmnCategory bean);

    @Delete("DELETE FROM ew_bpmn_category WHERE category_id = #{categoryId}")
    void delete(String categoryId);


    @Select("SELECT * FROM ew_bpmn_category")
    List<BpmnCategory> findAll();
    @Select("SELECT * FROM ew_bpmn_category")
    List<BpmnCategory> findByBean(BpmnCategoryVO vo);

}
