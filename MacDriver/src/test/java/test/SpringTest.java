package test;




import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.min.service.SignService;
//import com.min.service.StudentService;

public class SpringTest {

	private ApplicationContext content;
//	private StudentService service;
//	private TeacherService service2;
//	private SheetService service3;
	private SignService service4;
	
	@Before
	public void before(){
		this.content = new ClassPathXmlApplicationContext("applicationContext.xml");
//		this.service = (StudentService) content.getBean("studentServiceImpl");
		this.service4 = (SignService) content.getBean("signServiceImpl");
//		this.service2 = (TeacherService) content.getBean("teacherServiceImpl");
//		this.service3 = (SheetService) content.getBean("sheetServiceImpl");
//		this.controller = (StudentController) content.getBean("studentController");
	}
		
	@Test
	public void testOne(){
//		Student stu = new Student();
//		stu.setClassNum("1506011");
//		stu.setName("老王");
//		stu.setStudentNum("1501511554");
//		stu.setMacPath("asdwasxcvf");
//		stu.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//		System.out.println(this.service.addStudentInfo(stu));
		
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		Date dayone = new Date();
//		params.put("signTime", MatchTools.converDate(dayone));
//		params.put("part", "1_12");
//		System.out.println(this.service4.getDateAndCrouseIsCopy(params));
//		System.out.println(this.service2.getLoginTeaInfo(params));
		
		System.out.println(this.service4.updateIsSignZero("366ef220-6e80-4db6-92b2-c28ce39aa53a"));
		
	}
	
	
}
