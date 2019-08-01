package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeDepartment;
import org.easymis.workflow.app.entity.organize.OrganizeDepartmentVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeDepartmentService {
	public Boolean save(OrganizeDepartment bean);

	public Boolean update(OrganizeDepartment bean);

	public Boolean delete(String id);

	public OrganizeDepartment get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeDepartmentVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizeDepartment>    返回类型
	* @throws
	 */
	public List<OrganizeDepartment> findAll();
	
	public DataTableResult findByDataTable(OrganizeDepartmentVO vo);
	
}
