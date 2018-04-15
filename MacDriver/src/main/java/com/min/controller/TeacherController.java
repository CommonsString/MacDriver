package com.min.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.domain.Sheet;
import com.min.domain.Sign;
import com.min.domain.Student;
import com.min.service.SheetService;
import com.min.service.SignService;
import com.min.service.StudentService;
import com.min.service.TeacherService;
import com.tools.MatchTools;

import net.sf.json.JSONArray;


@RequestMapping("/tea")
@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teaService;
	
	@Autowired
	private SheetService sheetService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SignService signService;
	
	//
	@SuppressWarnings("unused")
	private static JSONArray temp = new JSONArray();

	//发送消息
	@RequestMapping("/signMsg")
	@ResponseBody
	public Map<String, Object> signMsg(HttpServletRequest request){
		HashMap<String, Object> params = null;
		HashMap<String, Object> map = null;
		JSONArray tempJson = null; //临时对象
		try {
			params = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			String tempList = request.getParameter("signed_address_list");
			String teaId = request.getParameter("teaId");
			String sign_time = request.getParameter("sign_time");
			map.put("teaId", teaId); //填充
			map.put("part", sign_time);
			tempJson = JSONArray.fromObject(tempList); //解析
			
			//打印参数
System.out.println(tempJson.toString() + ":  signed_address_list");
System.out.println(teaId + "  teaId");
System.out.println(sign_time + " ：sign_time");
System.out.println(tempJson.isEmpty() + "::tempJson.isEmpty()");
			
			if(tempJson.isEmpty()){ //确保蓝牙地址不为空
				params.put("msg", "蓝牙地址不为空");
				params.put("status", "false");
				return params;
			}
			
			
			if(!"".equals(teaId) && teaId != null
					&& !"".equals(sign_time) && sign_time != null){
				//根据sign_time查找课程表，获取课表信息 
				Sheet sheet = sheetService.getInfoSheet(map); //课表,获取班级
				if(sheet != null){
					//查询所有学生列表 list //姓名，班级，学号，课程名，是否签到
					List<Student> listStu = studentService.getAllStuForList(sheet.getClassNum());
					if(listStu.size() != 0){
						//匹配成功，修改签到信息表,添加学号，姓名，班级编号，教师，课程名
						MatchTools.matcingMacPath(tempJson, listStu, signService, sheet);
						List<Sign> signStudents = signService.getSignStudentForList(sheet.getClassNum());
						List<Sign> unSignStudents = signService.getUnSignStudentForList(sheet.getClassNum());
						params.put("status", "true");
						params.put("msg", "good！");
						params.put("signStudents", signStudents);
						params.put("unSignStudents", unSignStudents);
						return params;
					}else{
						params.put("status", "false");
						params.put("msg", "不存在该班级，请重试");
					}
				}else{
					params.put("status", "false");
					params.put("msg", "数据出错，请重试");
				}
			}else{
				params.put("status", "false");
				params.put("msg", "参数错误!");
			}
		} catch (Exception e) {
				params.put("status", "false");
				params.put("msg", "系统错误，请稍后重试！");
				e.printStackTrace();
				}
		return params;
}	
	
	
	@RequestMapping("/login_teacher")
	@ResponseBody
	public Map<String, Object> login_teacher(String account, String password){
		
		HashMap<String, Object> params = null;
		HashMap<String, Object> map = null;
System.out.println(account + ": 账号  " + password + " : 密码");
		try {
			params = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			if(!"".equals(account) && account != null
					&& !"".equals(password) && password != null){
				map.put("account", account);
				map.put("password", DigestUtils.md5DigestAsHex(password.getBytes()));
				String teaId = teaService.getLoginTeaInfo(map);
System.out.println(teaId + " :  teaId");
				if(teaId == null){
					params.put("status", "false");
					return params;
				}else{
					params.put("status", "true");
					params.put("teacher_id", teaId);
				}
			}else{
				params.put("status", "false");
				params.put("msg", "数据出错，请重试！");
			}
		} catch (Exception e) {
			params.put("status", "false");
			params.put("msg", "系统错误，请稍后重试！");
			e.printStackTrace();
		}
		return params;
	}
	
	
}
