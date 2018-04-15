package com.base.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录日志
 */
@Setter
@Getter
public class ipLog {
	
	public static final int STATE_SUCCESS = 1; //登录成功
	public static final int STATE_FAULT = 0; //登录失败
	
	private String ipLogId;
	private String ipPath; //ip地址
	private Date loginTime; //登录时间
	private String userName; //用户名
	private int state; //登录结果 成功/失败
	
	public String getStateDisplay(){
		return this.state == STATE_SUCCESS ? "登录成功" : "登录失败";
	}
	
}
