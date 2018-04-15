package com.base.service;

import java.util.HashMap;

import com.base.domain.Teacher;



public interface TeacherService {
	
	public String getLoginTeaInfo(HashMap<String, Object> params);  //教师登录验证
	
	
	//重构分界线
	public Teacher getLogInfo(String account, String password, String ipPath);


	public void initAccount();
	
}
