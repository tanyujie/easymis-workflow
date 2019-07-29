package org.easymis.workflow.app.service.bpmn;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnInstanceDefineHis;
import org.easymis.workflow.app.entity.vo.BpmnInstanceDefineHisVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmnInstanceDefineHisService {
	public Boolean save(BpmnInstanceDefineHis bean);

	public Boolean update(BpmnInstanceDefineHis bean);

	public Boolean delete(String id);

	public BpmnInstanceDefineHis get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnInstanceDefineHisVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnInstanceDefineHis>    返回类型
	* @throws
	 */
	public List<BpmnInstanceDefineHis> findAll();
	
	public DataTableResult findByDataTable(BpmnInstanceDefineHisVO vo);
}
