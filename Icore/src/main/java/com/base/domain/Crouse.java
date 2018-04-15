package com.base.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 */
@Setter
@Getter
@ToString
public class Crouse {
	
	private String sheetId;
	private String teaId; 
	private String crouseName;
	private String classNum;
	private String classRoom;
	
	private Date begin; //课程开始时间
	private Date end; //课程结束时间
	private String part; //节数 3_12

}
