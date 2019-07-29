package org.easymis.workflow.app.service.bpmn;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnOperLog;
import org.easymis.workflow.app.entity.vo.BpmnOperLogVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmnOperLogService {
	public Boolean save(BpmnOperLog bean);

	public Boolean update(BpmnOperLog bean);

	public Boolean delete(String id);

	public BpmnOperLog get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnOperLogVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnOperLog>    返回类型
	* @throws
	 */
	public List<BpmnOperLog> findAll();
	
	public DataTableResult findByDataTable(BpmnOperLogVO vo);
}
