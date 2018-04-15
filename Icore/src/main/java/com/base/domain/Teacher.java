package com.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Teacher {
	
	private String teaId;
	private String account; //账号
	private String name;
	private String college; //学院
	private String password; //密码
	
	private String touch; //联系方式
	private String titleJob; //职称
	private String sex; 
	

}
