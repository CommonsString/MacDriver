package com.base.utils;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.base.domain.Student;
import com.base.domain.Teacher;

/**
 * 存放当前用户上下文
 * session
 */
public class UserContext {
	
	public static final String STU_IN_SESSION = "loginstu";  //学生端
	public static final String TEA_IN_SESSION = "loginutea";  //教师端
	
	/**
	 * spring获取session
	 * @return
	 */
	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
	}
	
	
	public static void putStuInfo(Student student){
		getSession().setAttribute(STU_IN_SESSION, student);
	}
	
	public static Student getStuInfo(){
		return (Student) getSession().getAttribute(STU_IN_SESSION);
	}
	
	public static void putTeaInfo(Teacher teacher){
		getSession().setAttribute(TEA_IN_SESSION, teacher);
	}
	
	public static Teacher getTeaInfo(){
		return (Teacher) getSession().getAttribute(TEA_IN_SESSION);
	}
	
}
