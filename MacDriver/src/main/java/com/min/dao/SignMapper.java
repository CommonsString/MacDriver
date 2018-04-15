package com.min.dao;

import java.util.HashMap;
import java.util.List;

import com.min.domain.Sign;

public interface SignMapper {
	
	public int addSignChangeInfo(Sign sign); //修改签到信息
	
	public List<Sign> getSignStudentForList(String classNums); //返回签到学生表
	
	public List<Sign> getUnSignStudentForList(String classNums); //返回未签到学生表
	
	public int updateIsSign(String stuNum); //更新字段
	
	public int updateIsSignZero(String macPath); //更新字段
	
	public int getDateAndCrouseIsCopy(HashMap<String, Object> params); //查重手段
	
	public Sign getMacPathBySign(String macPath); //根据蓝牙地址查找

}
