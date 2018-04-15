package com.base.mapper;

import com.base.domain.Cost;

public interface CostMapper {
	
	int getDetailIsExist(String classNum);
	
	Cost getNewDateDetails(String classNum);
	
	void insertDetails(Cost cost);

}
