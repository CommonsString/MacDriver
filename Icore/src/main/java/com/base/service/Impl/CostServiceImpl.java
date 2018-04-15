package com.base.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.Cost;
import com.base.mapper.CostMapper;
import com.base.service.CostService;

@Service
public class CostServiceImpl implements CostService{

	@Autowired
	private CostMapper mapper;
	
	@Override
	public int getDetailIsExist(String classNum) {
		int result = this.mapper.getDetailIsExist(classNum);
		if(result <= 0){
			return -1;
		}
		return result;
	}

	@Override
	public Cost getNewDateDetails(String classNum) {
		Cost cost = this.mapper.getNewDateDetails(classNum);
		return cost;
	}

	@Override
	public void insertDetails(Cost cost) {
		try {
			this.mapper.insertDetails(cost);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	

}
