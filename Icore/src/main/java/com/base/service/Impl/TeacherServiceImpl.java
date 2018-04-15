package com.base.service.Impl;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.Teacher;
import com.base.domain.ipLog;
import com.base.mapper.TeacherMapper;
import com.base.service.IpLogService;
import com.base.service.TeacherService;
import com.base.utils.ConstAttrbute;
import com.base.utils.UserContext;


@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper mapper;
	
	@Autowired
	private IpLogService ipService;

	@Override
	public String getLoginTeaInfo(HashMap<String, Object> params) {
		
		return mapper.getLoginTeaInfo(params);
	}

	
	
	@Override
	public Teacher getLogInfo(String account, String password, String ipPath) {
		Teacher tea = this.mapper.getLogInfo(account, password);
		ipLog log = new ipLog();
		log.setIpPath(ipPath);
		log.setLoginTime(new Date());
		log.setUserName(account);
		if(tea != null){
			UserContext.putTeaInfo(tea);
			log.setState(ipLog.STATE_SUCCESS);
		}else{
			log.setState(ipLog.STATE_FAULT);
		}
		this.ipService.addIplog(log);
		return tea;
	}



	@Override
	public void initAccount() {
		//查询是否有用户
		int result = this.mapper.getCountForTea(ConstAttrbute.DEFAULT_ACCOUNT);
		if(result <= 0){
			Teacher tea = new Teacher();
			tea.setAccount(ConstAttrbute.DEFAULT_ACCOUNT);
			tea.setPassword(ConstAttrbute.DEFAULT_ACCOUNT);
			tea.setName("测试");
			this.mapper.addTeacher(tea);
		}
	}
	
}
