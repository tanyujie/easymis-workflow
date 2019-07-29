package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnInstanceDefine;
import org.easymis.workflow.app.entity.vo.BpmnInstanceDefineVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmInstanceDefineService {
	public Boolean save(BpmnInstanceDefine bean);

	public Boolean update(BpmnInstanceDefine bean);

	public Boolean delete(String id);

	public BpmnInstanceDefine get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnInstanceDefineVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnInstanceDefine>    返回类型
	* @throws
	 */
	public List<BpmnInstanceDefine> findAll();
	
	public DataTableResult findByDataTable(BpmnInstanceDefineVO vo);
}
