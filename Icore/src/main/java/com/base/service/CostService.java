package com.base.service;

import com.base.domain.Cost;

public interface CostService {

	int getDetailIsExist(String classNum);

	Cost getNewDateDetails(String classNum);

	void insertDetails(Cost cost);
	
	

}
