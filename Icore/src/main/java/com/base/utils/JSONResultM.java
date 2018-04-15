package com.base.utils;


import com.base.domain.Cost;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class JSONResultM {
	
	public Boolean success = true;
	private String msg;
	
	private Cost cost;
	
	public JSONResultM() {
	}
	
	public JSONResultM(String msg) {
		this.msg = msg;
	}

	public JSONResultM(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public JSONResultM(Boolean success, String msg, Cost cost) {
		super();
		this.success = success;
		this.msg = msg;
		this.cost = cost;
	}
	

}
