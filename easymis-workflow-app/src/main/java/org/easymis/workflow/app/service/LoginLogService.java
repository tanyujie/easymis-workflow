package org.easymis.workflow.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.easymis.workflow.app.entity.system.LoginLog;
import org.easymis.workflow.app.mapper.LoginLogMapper;
import org.easymis.workflow.app.utils.UUIDUtils;
import org.easymis.workflow.app.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class LoginLogService {
	@Autowired
	private LoginLogMapper loginLogMapper;

	public LoginLog findById(String loginLogId) {
		return loginLogMapper.findById(loginLogId);
	}

	public boolean save(LoginLog bean) {
		boolean flag = false;
		try {
			bean.setLoginLogId(UUIDUtils.getUUID());
			bean.setLoginTime(new Date());
			loginLogMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<LoginLog> findAll() {
		return loginLogMapper.findAll();
	}
	public DataTableResult  findAll(Map<String, Object> map, int page, int rows) {
        PageHelper.startPage(page, rows);
        DataTableResult result=new DataTableResult();
		List<LoginLog> itemList = loginLogMapper.findAll();
		result.setData(itemList);
		PageInfo<LoginLog> info=new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());

		return result;
		
	}
}
