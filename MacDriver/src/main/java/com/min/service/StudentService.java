package com.min.service;

import java.util.HashMap;
import java.util.List;

import com.min.domain.Sign;
import com.min.domain.Student;

public interface StudentService {
	
	public Student getStudentByClassNum(String classNum);
	
	public boolean addStudentInfo(Student student); //学生注册
	
	public Student getLoginStuInfo(HashMap<String, Object> params); //学生登录验证
	
	public List<Sign> getListSign(String stuNum);  //返回签到信息
	
	public List<Student> getAllStuForList(String classNum); //返回所有学生信息
	
	
}
