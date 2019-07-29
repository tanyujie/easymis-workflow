package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizeResource;
import org.easymis.workflow.app.entity.vo.OrganizeResourceVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeResourceService {
	public Boolean save(OrganizeResource bean);

	public Boolean update(OrganizeResource bean);

	public Boolean delete(String id);

	public OrganizeResource get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeResourceVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizeResource>    返回类型
	* @throws
	 */
	public List<OrganizeResource> findAll();
	
	public DataTableResult findByDataTable(OrganizeResourceVO vo);
}
