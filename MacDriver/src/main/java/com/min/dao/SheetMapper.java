package com.min.dao;


import java.util.HashMap;

import com.min.domain.Sheet;

public interface SheetMapper {
	
	public Sheet getInfoSheet(HashMap<String, Object> params); //定位课表
	
}
