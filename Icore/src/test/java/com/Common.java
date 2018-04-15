package com;



//import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.domain.Cost;
import com.base.service.CostService;


/**
 * spring测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-core.xml")
public class Common {
	
//	@Autowired
//	private StudentService service;
	
	@Autowired
	private CostService service;
	
	
	@Test
	public void tets(){
//		ArrayList<String> path = new ArrayList<String>();
//		
//		path.add("d3b55d4a-4135-4eaf-9335-98e261d4f51d");
//		path.add("2a19f09a-5c43-4d15-a14e-3115daa21afc");
//		
//		ArrayList<Student> list1 = (ArrayList<Student>) this.service.getSignListStu(path);
//		System.out.println(list1.toString());
//		
//		for(Student stu : list1){
//			System.out.println(stu.getMacPath());
			
		Cost cost = this.service.getNewDateDetails("1506011");
		System.out.println(cost.toString());
	}

}
