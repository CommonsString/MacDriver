package com.tools;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JSONResult {
	
	public Boolean success = true;
	private String msg;
	private Map<String, Object> map;
	
	public JSONResult() {
	}
	
	public JSONResult(String msg) {
		this.msg = msg;
	}

	public JSONResult(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public JSONResult(Boolean success, String msg, Map<String, Object> map) {
		this.success = success;
		this.msg = msg;
		this.map = map;
	}
	
	
}
