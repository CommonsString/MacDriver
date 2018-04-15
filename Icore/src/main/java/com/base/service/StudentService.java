package com.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.base.domain.Sign;
import com.base.domain.Student;


public interface StudentService {
	
	public Student getStudentByClassNum(String classNum);
	
	public void addStudentInfo(Student student); //学生注册
	
	public Student getLoginStuInfo(HashMap<String, Object> params); //学生登录验证
	
	public List<Sign> getListSign(String stuNum);  //返回签到信息
	
	
	
	//重构分界线

	public int getCountForStudent(String studentNum);

	public void addStuRegisteredInfo(Student student, String studentNum, String password);

	public Student getLoginInfo(String studentNum, String password, String ip);
	
	public List<Student> getAllStuForList(String classNum); //返回所有学生信息

	public HashMap<String, Object> match(ArrayList<String> path, String teaId, String signTime);
	
	public List<Student> getSignListStu(ArrayList<String> path); //删除

}
