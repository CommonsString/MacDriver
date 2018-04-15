package com.base.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.ipLog;
import com.base.mapper.ipLogMapper;
import com.base.service.IpLogService;


@Service
public class IpLogServiceImpl implements IpLogService {
	
	@Autowired
	private ipLogMapper mapper;

	@Override
	public void addIplog(ipLog log) {
		int result = this.mapper.addIplog(log);
		if(result <= 0){
			throw new RuntimeException("iplog : 异常");
		}
	}
	
}
