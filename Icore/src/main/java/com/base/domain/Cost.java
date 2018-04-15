package com.base.domain;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Cost {
	
	private String costId;
	
	private String classNum; //班级
	private String name; //经手人名字
	private double total; //总额，默认0
	private double currentCost; //当前花费，默认0
	
	private Date time; //日期
	private String details; //备注

}
