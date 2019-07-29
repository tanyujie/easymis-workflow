package org.easymis.workflow.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.workflow.app.entity.organize.OrganizeGroup;
import org.easymis.workflow.app.entity.system.LoginLog;
import org.easymis.workflow.app.entity.vo.OrganizeGroupVO;

public interface OrganizeGroupMapper {
    @Select("SELECT * FROM dam_login_log WHERE login_log_id = #{loginLogId}")
    LoginLog findById(@Param("loginLogId") String loginLogId);
    @Insert("INSERT INTO dam_login_log(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_login_log(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_login_log(login_log_id, creator_id, creator, login_time, login_type, ip, place, device_type, kernel, platform, IMEI, certified_result, delegate_user) "
    		+ "VALUES(#{loginLogId}, #{creatorId}, #{creator}, #{loginTime}, #{loginType}, #{ip}, #{place}, #{deviceType}, #{kernel}, #{platform}, #{imei}, #{certifiedResult}, #{delegateUser})")
    int insertByBean(OrganizeGroup bean);

    @Update("UPDATE dam_login_log leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void update(LoginLog bean);

    @Delete("DELETE FROM dam_login_log WHERE role_id = #{roleId}")
    void delete(String roleId);


    @Select("SELECT * FROM dam_login_log")
    List<OrganizeGroup> findAll();
    @Select("SELECT * FROM ew_bpmn_category")
    List<OrganizeGroup> findByBean(OrganizeGroupVO vo);
}
