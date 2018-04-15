package com.min.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sign {
	
	private String signId;
	private String stuNum; //学号
	private String stuName; //名字
	private String classNums; //班级号
	
	private int isSign;  //签到状态
	private String classRoom; //教室
	private String crouseNam; //课程名
	private String signTime;  //签到时间
	private String macPath; //蓝牙地址
	private String part;  //节数
	
}
