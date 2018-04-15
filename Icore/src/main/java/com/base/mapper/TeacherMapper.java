package com.base.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.base.domain.Teacher;


public interface TeacherMapper {
	
	public String getLoginTeaInfo(HashMap<String, Object> params); //教师登录验证
	
	//重构分割线
	public Teacher getLogInfo(@Param("account") String account, @Param("password") String password);

	public int getCountForTea(String account);

	public void addTeacher(Teacher tea);
	


}
