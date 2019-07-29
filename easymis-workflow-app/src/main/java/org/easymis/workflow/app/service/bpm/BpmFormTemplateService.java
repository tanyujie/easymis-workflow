package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormTemplate;
import org.easymis.workflow.app.entity.vo.FormTemplateVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;


public interface BpmFormTemplateService {
	public Boolean save(FormTemplate bean);

	public Boolean update(FormTemplate bean);

	public Boolean delete(String id);
	public FormTemplate get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(FormTemplateVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<FormTemplate>    返回类型
	* @throws
	 */
	public List<FormTemplate> findAll();
	
	public DataTableResult findByDataTable(FormTemplateVO vo);
}
