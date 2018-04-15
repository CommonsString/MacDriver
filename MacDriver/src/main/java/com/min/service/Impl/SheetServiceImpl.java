package com.min.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.SheetMapper;
import com.min.domain.Sheet;
import com.min.service.SheetService;


@Service
public class SheetServiceImpl implements SheetService {

	@Autowired
	private SheetMapper mapper;
	
	//定位课表
	@Override
	public Sheet getInfoSheet(HashMap<String, Object> params) {
		return mapper.getInfoSheet(params);
	}

}
