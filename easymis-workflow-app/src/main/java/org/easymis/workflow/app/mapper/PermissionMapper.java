package org.easymis.workflow.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.workflow.app.entity.Permission;
import org.easymis.workflow.app.entity.Role;

@Mapper
public interface PermissionMapper {
    @Select("SELECT * FROM dam_role WHERE dbs_id = #{dbsId}")
    Permission findById(@Param("dbsId") String dbsId);

	@Select("SELECT dam_permission.* FROM dam_permission left join "
			+ " dam_role_permission on dam_permission.permission_id=dam_role_permission.permission_id "
			+ " WHERE dam_role_permission.role_id = #{roleId}")
	Permission findByRoleId(@Param("roleId") String roleId);
    @Insert("INSERT INTO dam_role(Permission_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_dbs(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_role(role_id, role_name, is_super,priority,system_default,depict) VALUES(#{roleId}, #{roleName}, #{isSuper}, #{priority}, #{systemDefault},#{depict})")
    int insertByBean(Role bean);

    @Update("UPDATE dam_role leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void update(Permission bean);

    @Delete("DELETE FROM dam_role WHERE role_id = #{roleId}")
    void delete(String roleId);

    @Results({
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "isSuper", column = "is_super"),
            @Result(property = "priority", column = "priority"),
            @Result(property = "systemDefault", column = "system_default"),
            @Result(property = "depict", column = "depict")
    })
    @Select("SELECT * FROM sys_permission")
    List<Permission> findAll();
}
