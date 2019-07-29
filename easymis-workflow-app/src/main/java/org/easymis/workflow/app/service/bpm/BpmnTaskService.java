package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnTask;
import org.easymis.workflow.app.entity.vo.BpmnTaskVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmnTaskService {
	public Boolean save(BpmnTask bean);

	public Boolean update(BpmnTask bean);

	public Boolean delete(String id);

	public BpmnTask get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnTaskVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnTask>    返回类型
	* @throws
	 */
	public List<BpmnTask> findAll();
	public Boolean completeBatch(String taskIds[],String opinion,String actionName);
	public DataTableResult findByDataTable(BpmnTaskVO vo);
}
