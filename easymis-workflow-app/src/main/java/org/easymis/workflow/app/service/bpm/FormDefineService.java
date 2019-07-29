package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormDefine;
import org.easymis.workflow.app.entity.vo.FormDefineVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface FormDefineService {
	public Boolean save(FormDefine bean);

	public Boolean update(FormDefine bean);

	public Boolean delete(String id);
	public FormDefine get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(FormDefineVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<FormDefine>    返回类型
	* @throws
	 */
	public List<FormDefine> findAll();
	
	public DataTableResult findByDataTable(FormDefineVO vo);
}
