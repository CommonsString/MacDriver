package com.base.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.Sign;
import com.base.mapper.SignMapper;
import com.base.service.SignService;


@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private SignMapper mapper;

	@Override
	public void addSignInfo(Sign sign) {
		int result = this.mapper.addSignInfo(sign);
		if(result <= 0){
			throw new RuntimeException("EX:addSignInfo");
		}
	}

	
	//乐观锁支持
	@Override
	public void updateInfo(Sign sign) {
		int result = this.mapper.updateInfo(sign);
		if(result <= 0){
			throw new RuntimeException("EX:乐观锁失败");
		}
	}

}
