package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.FormDataTemplate;
import org.easymis.workflow.app.entity.vo.FormDataTemplateVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface FormDataTemplateService {
	public Boolean save(FormDataTemplate bean);

	public Boolean update(FormDataTemplate bean);

	public Boolean delete(String id);
	public FormDataTemplate get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(FormDataTemplateVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<FormDataTemplate>    返回类型
	* @throws
	 */
	public List<FormDataTemplate> findAll();
	
	public DataTableResult findByDataTable(FormDataTemplateVO vo);
}
