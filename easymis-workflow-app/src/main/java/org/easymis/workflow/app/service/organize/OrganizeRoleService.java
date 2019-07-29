package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeRole;
import org.easymis.workflow.app.entity.vo.OrganizeRoleVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeRoleService {
	public Boolean save(OrganizeRole bean);

	public Boolean update(OrganizeRole bean);

	public Boolean delete(String id);

	public OrganizeRole get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeRoleVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizeRole>    返回类型
	* @throws
	 */
	public List<OrganizeRole> findAll();
	
	public DataTableResult findByDataTable(OrganizeRoleVO vo);
}
