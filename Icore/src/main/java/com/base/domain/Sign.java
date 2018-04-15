package com.base.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sign {
	
	private String signId;
	private String teaId;
	private String signStu;
	private String unSignStu;
	
	private int version; //乐观锁
	
}
