package com.base.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.Crouse;
import com.base.mapper.CrouseMapper;
import com.base.service.CrouseService;


@Service
public class CrouseServiceImpl implements CrouseService {

	@Autowired
	private CrouseMapper mapper;
	
	//定位课表
	@Override
	public Crouse getInfoSheet(HashMap<String, Object> params) {
		return mapper.getInfoSheet(params);
	}

	@Override
	public Crouse getCrouseByParams(String teaId, String signTime) {
		Crouse cro =  mapper.getCrouseByParams(teaId, signTime);
		if(cro == null){
			throw new RuntimeException("EX:cro!");
		}
		return cro;
	}
	
	
	
	
}
