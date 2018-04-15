package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.domain.Teacher;
import com.base.service.TeacherService;
import com.base.utils.CommonUtils;
import com.base.utils.JSONResult;

/**
 * 登录相关逻辑
 */
@Controller
public class LoginController {
	
	private TeacherService teaService;
	
	@RequestMapping("/login_teacher")
	@ResponseBody
	public JSONResult loginTeacher(String account, String password, HttpServletRequest request){
		
		JSONResult json = new JSONResult();
		if(!"".equals(account) && account != null
				&& !"".equals(password) && password != null){
			String tempPswd = CommonUtils.MD5(password);
			String ipPath = request.getRemoteAddr(); //本地运行，获取IPV6地址
			Teacher tea = this.teaService.getLogInfo(account, tempPswd, ipPath);
			if(tea != null){
				json.setStatus(true);
				json.setTea_id(tea.getTeaId());
			}else{
				json.setStatus(false);
			}
		}
		return json;
	}
}
