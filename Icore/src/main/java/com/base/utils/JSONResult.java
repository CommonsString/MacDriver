package com.base.utils;

import com.base.domain.Student;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回信息封装
 */
@Getter
@Setter
public class JSONResult {
	
	private Boolean status = true; //状态
	private String msg; //消息
	private String tea_id; //教师端
	
	private Student student;
	
	
	
	public JSONResult() {
	}
	
	public JSONResult(String msg) {
		this.msg = msg;
	}
	
	public JSONResult(Boolean success, String msg) {
		this.status = success;
		this.msg = msg;
	}

	public JSONResult(Boolean success, String msg, Student student) {
		this.status = success;
		this.msg = msg;
		this.student = student;
	}
	
}
