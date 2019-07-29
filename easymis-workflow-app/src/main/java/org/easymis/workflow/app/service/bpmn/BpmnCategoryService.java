package org.easymis.workflow.app.service.bpmn;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnCategory;
import org.easymis.workflow.app.entity.vo.BpmnCategoryVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmnCategoryService {
	public Boolean save(BpmnCategory bean);

	public Boolean update(BpmnCategory bean);

	public Boolean delete(String id);

	public BpmnCategory get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnCategoryVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnCategory>    返回类型
	* @throws
	 */
	public List<BpmnCategory> findAll();
	
	public DataTableResult findByDataTable(BpmnCategoryVO vo);
}
