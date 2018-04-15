package com.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.service.StudentService;
import com.base.utils.MatchTools;

@Controller
public class MatchController {
	
	@Autowired
	private StudentService stuService;
	
	//发送消息
	@RequestMapping("/signMsg")
	@ResponseBody
	public HashMap<String, Object> signMsg(String signed_address_list, String teaId, String sign_time){
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
System.out.println(signed_address_list + "   :   " );
			if(!"".equals(signed_address_list) && signed_address_list != null){
				ArrayList<String> path = MatchTools.beList(signed_address_list); //转成list
System.out.println(path.size());
				result = this.stuService.match(path, teaId, sign_time);
				return result;
			}
			throw new RuntimeException("EX:signed_address_list::IS NULL");
		} catch (Exception e) {
			result.put("status", false);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	

}
