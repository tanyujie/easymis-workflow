package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeGroup;
import org.easymis.workflow.app.entity.vo.OrganizeGroupVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeGroupService {
	public Boolean save(OrganizeGroup bean);

	public Boolean update(OrganizeGroup bean);

	public Boolean delete(String id);

	public OrganizeGroup get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeGroupVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizeGroup>    返回类型
	* @throws
	 */
	public List<OrganizeGroup> findAll();
	
	public DataTableResult findByDataTable(OrganizeGroupVO vo);
}
