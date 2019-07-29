package org.easymis.workflow.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.workflow.app.entity.Vacation;
@Mapper
public interface VacationMapper {
    @Select("SELECT * FROM oa_vacation WHERE user_id = #{userId}")
    List<Vacation> findByUserId(@Param("userId") String userId);
    @Insert("INSERT INTO oa_vacation(BEGIN_DATE, DAYS, END_DATE, process_Instance_Id, REASON, USER_ID, VAC_TYPE) "
    		+ "VALUES(#{beginDate}, #{days}, #{endDate}, #{processInstanceId}, #{reason}, #{userId}, #{vacationType})")
    int insertByBean(Vacation bean);
    
}
