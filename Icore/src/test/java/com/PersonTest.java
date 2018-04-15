package com;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.service.StudentService;


public class PersonTest {
	
	private ApplicationContext content;
	private StudentService service;
	
	@Before
	public void before(){
		this.content = new ClassPathXmlApplicationContext("application-core.xml");
		this.service = (StudentService) content.getBean("studentServiceImpl");
	}
	
	@Test
	public void testOne(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("studentNum", "1501511111");
		map.put("password", "64bdd02210dd55cb848974c26da164e8");
		System.out.println(this.service.getLoginStuInfo(map));
	}	
	
}
