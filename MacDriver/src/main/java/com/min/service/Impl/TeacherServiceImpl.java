package com.min.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.TeacherMapper;
import com.min.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper mapper;

	@Override
	public String getLoginTeaInfo(HashMap<String, Object> params) {
		
		return mapper.getLoginTeaInfo(params);
	}


	
	
}
