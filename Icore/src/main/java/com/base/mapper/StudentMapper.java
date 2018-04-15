package com.base.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.domain.Sign;
import com.base.domain.Student;



public interface StudentMapper {
	
	public Student getStudentByClassNum(String classNum);
	
	public int addStudentInfo(Student student); //学生注册
	
	public Student getLoginStuInfo(HashMap<String, Object> params); //学生登录验证
	
	public List<Sign> getListSign(String stuNum);  //返回签到信息
	
	public List<Student> getAllStuForList(String classNum); //返回所有学生信息
	
	//重构分界线
	public int getCountForStudent(String studentNum); //重构
	
	Student getLoginInfo(@Param("studentNum") String studentNum, @Param("password") String password);

	public List<Student> getSignListStu(List<String> macPath);
}

