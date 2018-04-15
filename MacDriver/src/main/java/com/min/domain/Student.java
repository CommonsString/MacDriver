package com.min.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
	
	private String studentId; 
	  
	private String studentNum; //学号
	private String name; //姓名
	private String sex; //性别
	private String password;  //密码
	
	private String className; //班级名
	private String classNum; //班级号
	private String college; //学院
	private String grade; //年级
	private String macPath; //蓝牙地址
	

}
