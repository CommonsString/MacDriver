package com.min.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.domain.Sign;
import com.min.domain.Student;
import com.min.service.StudentService;

@RequestMapping("/stu")
@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	//学生注册
	@SuppressWarnings("unused")
	@RequestMapping("/registeredStu")
	@ResponseBody
	public Map<String, Object> registeredStu(Student student, String password){
		
		HashMap<String, Object> params = null;
		
System.out.println(student.toString());
System.out.println(password + "：  密码");
		try {
			params = new HashMap<String, Object>();
			if(student != null){
				//存储,dao
				student.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
				boolean isSave = service.addStudentInfo(student);
				if(isSave){
					params.put("status", true);
					params.put("msg", "注册成功！");
				}else{
					params.put("status", false);
					params.put("msg", "数据错误，注册失败！");
				}
			}else{
				params.put("status", false);
				params.put("msg", "填写信息有误，注册失败！");
			}
		} catch (Exception e) {
			params.put("status", false);
			params.put("msg", "系统错误，请稍后重试！");
			e.printStackTrace();
		}
		return params;
	}
	
	//学生登录
	@RequestMapping("/loginStudent")
	@ResponseBody
	public Map<String, Object> loginStudent(String studentNum, String password){
		
		HashMap<String, Object> params = null; //json
		HashMap<String, Object> map = null; //dao
		
System.out.println(studentNum + ":  " + password + "接收");
//		String temp = request.getParameter("studentNum");
//		String temp2 = request.getParameter("password");
//System.out.println(temp + " : " + temp2 + " : temp request接收");

		try {
			params = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			if(!"".equals(studentNum) && studentNum != null
					&& !"".equals(password) && password != null){
				//账号密码匹配, 返回用户信息,dao操作
				map.put("studentNum", studentNum);
				map.put("password", DigestUtils.md5DigestAsHex(password.getBytes()));
				Student student = service.getLoginStuInfo(map);
				if(student != null){
					params.put("status", true);
					params.put("msg", "登录成功！");
					params.put("student", student);
				}else{
					params.put("status", false);
					params.put("msg", "账号或密码错误，请重试！");
				}
			}else{
				params.put("status", false);
				params.put("msg", "账号密码为空！");
			}
		} catch (Exception e) {
			params.put("status", false);
			params.put("msg", "系统错误！");
			e.printStackTrace();
		}
		return params;
	}	
	
	
	//学生登录
	@RequestMapping("/historySign")
	@ResponseBody
	public Map<String, Object> historySign(String studentNum){
		
		HashMap<String, Object> params = null; //json
System.out.println(studentNum + " ：  学号");
		try {
			params = new HashMap<String, Object>();
			if(!"".equals(studentNum) && studentNum != null){
				//sign : 查看签到情况
				List<Sign> list = service.getListSign(studentNum);
				if(list.isEmpty()){
					params.put("status", false);
					params.put("msg", "没有签到信息！");
					return params;
				}
				//非空
				params.put("status", false);
				params.put("msg", "没有签到信息！");
				params.put("sign", list);
			}else{
				params.put("status", false);
				params.put("msg", "操作异常！");
			}
		} catch (Exception e) {
			params.put("status", false);
			params.put("msg", "系统错误！");
			e.printStackTrace();
		}
		return params;
	}		
	
}
