package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.OrganizePosition;
import org.easymis.workflow.app.entity.vo.OrganizePositionVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizePositionService {
	public Boolean save(OrganizePosition bean);

	public Boolean update(OrganizePosition bean);

	public Boolean delete(String id);

	public OrganizePosition get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizePositionVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<OrganizePosition>    返回类型
	* @throws
	 */
	public List<OrganizePosition> findAll();
	
	public DataTableResult findByDataTable(OrganizePositionVO vo);
}
