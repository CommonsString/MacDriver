package com.base.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	
	private long studentId; 
	  
	private String studentNum; //学号
	private String name; //姓名
	private String sex; //性别
	private String password;  //密码
	
	private String className; //班级名
	private String classNum; //班级号
	private String college; //学院
	private String grade; //年级
	private String macPath; //蓝牙地址
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; //地址相同，同一对象
		if(obj == null || getClass() != obj.getClass()) return false; //空，类型不等
		Student student = (Student) obj;
		return this.studentId == student.studentId; //根据学生ID比较
	}
	
}
