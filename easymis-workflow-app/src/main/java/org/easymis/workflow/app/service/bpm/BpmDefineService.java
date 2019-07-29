package org.easymis.workflow.app.service.bpm;

import java.util.List;

import org.easymis.workflow.app.entity.bpm.BpmnDefine;
import org.easymis.workflow.app.entity.vo.BpmnDefineVO;
import org.easymis.workflow.app.web.DataTableResult;

import com.github.pagehelper.PageInfo;

public interface BpmDefineService {
	public Boolean save(BpmnDefine bean);

	public Boolean update(BpmnDefine bean);

	public Boolean delete(String id);
	Boolean deleteDeployment(String deploymentId);
	public BpmnDefine get(String id);
	/**
	 * 
	* @Title: 查询全部分页显示
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param vo
	* @param @return    设定文件
	* @return PageInfo    返回类型
	* @throws
	 */
	public PageInfo findByPage(BpmnDefineVO vo);
	/**
	 * 
	* @Title: 查询全部不分页
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<BpmnDefine>    返回类型
	* @throws
	 */
	public List<BpmnDefine> findAll();
	
	public DataTableResult findByDataTable(BpmnDefineVO vo);
}
