package org.easymis.workflow.app.service.organize;

import java.util.List;

import org.easymis.workflow.app.entity.organize.Organize;
import org.easymis.workflow.app.entity.organize.OrganizeVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface OrganizeService {
	public Boolean save(Organize bean);

	public Boolean update(Organize bean);

	public Boolean delete(String id);

	public Organize get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(OrganizeVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<Organize>    返回类型
	* @throws
	 */
	public List<Organize> findAll();
	
	public DataTableResult findByDataTable(OrganizeVO vo);
}
