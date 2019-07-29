package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeEmployee;
import org.easymis.workflow.app.entity.vo.OrganizeEmployeeVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeEmployeeService {
	public Boolean save(OrganizeEmployee bean);

	public Boolean update(OrganizeEmployee bean);

	public Boolean delete(String id);
	public Boolean disable(String id);
	
	public OrganizeEmployee get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeEmployeeVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizeEmployee>    返回类型
	* @throws
	 */
	public List<OrganizeEmployee> findAll();
	
	public DataTableResult findByDataTable(OrganizeEmployeeVO vo);
}
