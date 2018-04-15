package com.min.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.SignMapper;
import com.min.domain.Sign;
import com.min.service.SignService;


@Service
public class SignServiceImpl implements SignService {

	
	@Autowired
	private SignMapper mapper;
	
	@Override
	public int addSignChangeInfo(Sign sign) {
		return mapper.addSignChangeInfo(sign);
	}


	//返回未签到信息表
	@Override
	public List<Sign> getUnSignStudentForList(String classNums) {
		return mapper.getUnSignStudentForList(classNums);
	}

	//返回签到信息表
	@Override
	public List<Sign> getSignStudentForList(String classNums) {
		return mapper.getSignStudentForList(classNums);
	}

	//更新字段
	@Override
	public int updateIsSign(String stuNum) {
		return mapper.updateIsSign(stuNum);
	}


	@Override
	public boolean getDateAndCrouseIsCopy(HashMap<String, Object> params) {
		boolean flag = false;
		int result = this.mapper.getDateAndCrouseIsCopy(params);
System.out.println(result + " ： result");
		if(result > 0){
			flag = true;
		}
		return flag;
	}


	@Override
	public int updateIsSignZero(String macPath) {
		return mapper.updateIsSignZero(macPath);
	}


	@Override
	public Sign getMacPathBySign(String macPath) {
		return mapper.getMacPathBySign(macPath);
	}



}
