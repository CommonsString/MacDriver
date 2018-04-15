package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.domain.Student;
import com.base.service.StudentService;
import com.base.utils.CommonUtils;
import com.base.utils.JSONResult;

/**
 * 登录相关逻辑
 */
@Controller
public class LoginController {
	
	@Autowired
	private StudentService Stuservice;
	
	/**
	 * @param student  涉及状态，安全性不高
	 * @param studentNum 
	 * @param password
	 * @return JSONResult
	 * http://localhost:8088/registeredStu.mui?studentNum=1234556&password=123456
	 */
	@RequestMapping("/registeredStu")
	@ResponseBody
	public JSONResult registered(Student student, String studentNum, String password){
		JSONResult json = new JSONResult();
		try {
			if(!"".equals(studentNum) && studentNum != null
					&& !"".equals(password) && password != null){
				this.Stuservice.addStuRegisteredInfo(student, studentNum, password);
				json.setStatus(true);
			}else{
				json.setStatus(false);
				json.setMsg("学号或密码为空！");
			}
		} catch (Exception e) {
			json.setStatus(false);
			json.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	
	/**
	 * @param studentNum
	 * @param password
	 * @return 
	 * http://localhost:8088/loginStudent.mui?studentNum=1234556&password123456
	 */
	@RequestMapping("/loginStudent")
	@ResponseBody
	public JSONResult loginStudent(String studentNum, String password, HttpServletRequest request){
System.out.println("进入登录逻辑");
System.out.println("studentNum ： " + studentNum + " : password   " + password);
		JSONResult json = new JSONResult();
		if(!"".equals(studentNum) && studentNum != null
				&& !"".equals(password) && password != null){
			System.out.println("不为空");
			String tempPswd = CommonUtils.MD5(password);
			String ipPath = request.getRemoteAddr(); //本地运行，获取IPV6地址
			Student info = this.Stuservice.getLoginInfo(studentNum, tempPswd, ipPath);
System.out.println(info);
			if(info != null){
				json.setStatus(true);
				json.setMsg("登录成功！");
				json.setStudent(info);
			}else{
				json.setStatus(false);
			}
		}
		return json;
	}
	
	
}
