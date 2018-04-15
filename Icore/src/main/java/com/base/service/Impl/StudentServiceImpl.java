package com.base.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.domain.Crouse;
import com.base.domain.Sign;
import com.base.domain.Student;
import com.base.domain.ipLog;
import com.base.mapper.StudentMapper;
import com.base.service.CrouseService;
import com.base.service.IpLogService;
import com.base.service.StudentService;
import com.base.utils.CommonUtils;
import com.base.utils.MatchTools;
import com.base.utils.UserContext;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;
	
	@Autowired
	private IpLogService ipService;
	
	@Autowired
	private CrouseService croService;
	

	public Student getStudentByClassNum(String classNum) {
		return mapper.getStudentByClassNum(classNum);
	}


	@Override
	public void addStudentInfo(Student student) {
		this.mapper.addStudentInfo(student);
	}


	@Override
	public List<Sign> getListSign(String stuNum) {
		return mapper.getListSign(stuNum);
	}

	//学生登录
	@Override
	public Student getLoginStuInfo(HashMap<String, Object> params) {
		return mapper.getLoginStuInfo(params);
	}




	//重构分割线
	
	@Override
	public int getCountForStudent(String studentNum) {
		return this.mapper.getCountForStudent(studentNum);
	}
	
	@Override
	public void addStuRegisteredInfo(Student student, String studentNum, String password) {
		int result = this.getCountForStudent(studentNum);
		if(result <= 0){ //注册逻辑
			String tempPswd = CommonUtils.MD5(password); //密码加密
			student.setPassword(tempPswd);
			this.addStudentInfo(student);
		}else{
			throw new RuntimeException("注册失败，该用户已存在！");
		}
	}

	@Override
	public Student getLoginInfo(String studentNum, String password, String ip) {
		
		Student stu = this.mapper.getLoginInfo(studentNum, password);
		//登录日志逻辑
		ipLog log = new ipLog();
		log.setIpPath(ip);
		log.setLoginTime(new Date());
		log.setUserName(studentNum); //设置用户名
		if(stu != null){
			UserContext.putStuInfo(stu); //存入session
			log.setState(ipLog.STATE_SUCCESS); //登录成功
		}else{
			log.setState(ipLog.STATE_FAULT); 
		}
		this.ipService.addIplog(log);	//插入日志
		return stu;
	}
	
	@Override
	public List<Student> getAllStuForList(String classNum) {
		List<Student> list = mapper.getAllStuForList(classNum);
		if(list.isEmpty()){
			throw new RuntimeException("EX:getAllStuForList");
		}
		return list;
	}


	/**
	 * 匹配逻辑
	 */
	@Override
	public HashMap<String, Object> match(ArrayList<String> path, String teaId, String signTime) {
		HashMap<String, Object> result = null;
		Crouse nowCrouse = this.croService.getCrouseByParams(teaId, signTime);
		if(nowCrouse != null){ //匹配逻辑
			List<Student> allStu = this.getAllStuForList(nowCrouse.getClassNum());
			List<Student> signStu = this.getSignListStu(path); //获取签到学生
			List<Student> unSignStu = MatchTools.getUnsign(allStu, signStu); //未签到学生
			
			//修改sign表 待定
			
			result = new HashMap<String, Object>();
			result.put("signStu", signStu);
			result.put("unSignStu", unSignStu);
			result.put("status", true);
		}else{
			throw new RuntimeException("EX:match::nowCrouse is null");
		}
		return result;
	}

	@Override
	public List<Student> getSignListStu(ArrayList<String> path) {
		return this.mapper.getSignListStu(path);
	}
	
}
