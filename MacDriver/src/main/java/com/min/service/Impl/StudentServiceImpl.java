package com.min.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.StudentMapper;
import com.min.domain.Sign;
import com.min.domain.Student;
import com.min.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;

	public Student getStudentByClassNum(String classNum) {
		return mapper.getStudentByClassNum(classNum);
	}

	
	//学生注册
	@Override
	public boolean addStudentInfo(Student student) {
		boolean flag = false;
		try {
			int result = mapper.addStudentInfo(student);
			if(result != 0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return flag;
	}



	@Override
	public List<Sign> getListSign(String stuNum) {
		return mapper.getListSign(stuNum);
	}

	//学生登录
	@Override
	public Student getLoginStuInfo(HashMap<String, Object> params) {
		return mapper.getLoginStuInfo(params);
	}

	@Override
	public List<Student> getAllStuForList(String classNum) {
		return mapper.getAllStuForList(classNum);
	}



	
}
