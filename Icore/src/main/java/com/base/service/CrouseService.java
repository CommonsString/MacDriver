package com.base.service;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.base.domain.Crouse;

public interface CrouseService {
	
	public Crouse getInfoSheet(HashMap<String, Object> params); //定位课表

	//重构分界线
	public Crouse getCrouseByParams(@Param("teaId") String teaId, @Param("signTime") String signTime);


}
