package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BoDefine;
import org.easymis.workflow.app.entity.vo.BoDefineVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BoDefineService {

	public Boolean save(BoDefine bean);

	public Boolean update(BoDefine bean);

	public Boolean delete(String id);
	public BoDefine get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BoDefineVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BoDefine>    返回类型
	* @throws
	 */
	public List<BoDefine> findAll();
	
	public DataTableResult findByDataTable(BoDefineVO vo);

}
