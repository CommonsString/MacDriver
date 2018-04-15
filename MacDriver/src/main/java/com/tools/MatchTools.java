package com.tools;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.min.domain.Sheet;
import com.min.domain.Sign;
import com.min.domain.Student;
import com.min.service.SignService;

import net.sf.json.JSONArray;

/**
 * 工具类
 * @author CommonsString
 *
 */
public class MatchTools {
	
	//构造器私有化
	private MatchTools() {
	}
	
	public static boolean isMatchMacPath(Student student, String macPath){
		boolean flag = false;
		if(student != null && macPath != null){
			if(macPath.equals(student.getMacPath())){
				return true;
			}
		}
		return flag;
	}
	
	
	/**
	 * 预存sign
	 */
	private static void advanceSet(List<Student> listStu, SignService signService, Sheet sheet){
		
		for(Student stu : listStu){
			Sign sign = new Sign();
			sign.setStuNum(stu.getStudentNum()); //学号
			sign.setStuName(stu.getName()); //姓名
			sign.setClassNums(sheet.getClassNum());  //班级号
			sign.setClassRoom(sheet.getClassRoom());
			sign.setSignTime(converDate(new Date()));
			sign.setCrouseNam(sheet.getCrouseName());
			sign.setMacPath(stu.getMacPath());
			sign.setPart(sheet.getPart());
			sign.setIsSign(0); //默认
			signService.addSignChangeInfo(sign); //dao操作
		}
		
	}
	
	/**
	 * 蓝牙匹配
	 */
	public static void matcingMacPath(JSONArray tempJson, List<Student> listStu, SignService signService, Sheet sheet){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("signTime", MatchTools.converDate(new Date()));
		params.put("part", sheet.getPart());
System.out.println(sheet.getPart() + " ：part " + MatchTools.converDate(new Date()) + "signtime");
		boolean isCopy = signService.getDateAndCrouseIsCopy(params);
System.out.println(isCopy + "isCopy");
		if(isCopy){ //存在
			//匹配修改
System.out.println(tempJson.toString() + "蓝牙地址");
System.out.println(tempJson.size() + "蓝牙地址长度");
			//根据蓝牙地址查找
			for(int i = 0; i < tempJson.size(); i++){
				Sign isExtis = signService.getMacPathBySign(tempJson.getString(i));
				if(isExtis != null){
System.out.println(isExtis.toString() + "存在：  ");
					signService.updateIsSign(isExtis.getStuNum());
				}else{
System.out.println("不存在蓝牙地址：  " + tempJson.getString(i));
					signService.updateIsSignZero(tempJson.getString(i));
				}
			}
			//存在改为1
			//不存在改为0
			return; //判断
		}
		advanceSet(listStu, signService, sheet);
		//开始匹配
		for(int i = 0; i < listStu.size(); i++){
			for(int j = 0; j < tempJson.size(); j++){
				boolean flag = MatchTools.isMatchMacPath(listStu.get(i), tempJson.getString(j));
				if(flag){ //学号，姓名，班级号，教室，课程名 
					signService.updateIsSign(listStu.get(i).getStudentNum());
				}
			}
		}
	}
	
	/**
	 * 日期比较
	 * 只比较年月日
	 * @param dayone
	 * @param daytwo
	 * @return
	 */
	public static boolean isEqualDate(Date dayone, Date daytwo){
		boolean flag = false;
		if(dayone != null && daytwo != null){
			LocalDate localDate1 = ZonedDateTime.ofInstant(dayone.toInstant(), ZoneId.systemDefault()).toLocalDate(); 
			LocalDate localDate2 = ZonedDateTime.ofInstant(daytwo.toInstant(), ZoneId.systemDefault()).toLocalDate();	
			if(localDate1.equals(localDate2)) flag = true;
		}
		return flag;
	}
	
	/**
	 * 时间转换器
	 * @param date
	 * @return
	 */
	public static String converDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	/**
	 * 
	 * @param tempJson
	 * @param listStu
	 * @param signService
	 */
	public static void tempMatch(JSONArray tempJson, List<Student> listStu, SignService signService){
		for(int i = 0; i < listStu.size(); i++){
			for(int j = 0; j < tempJson.size(); j++){
				boolean flag = MatchTools.isMatchMacPath(listStu.get(i), tempJson.getString(j));
				//不匹配，修改信息表
				if(flag){ //学号，姓名，班级号，教室，课程名 
					signService.updateIsSign(listStu.get(i).getStudentNum());
				}
			}
		}		
	}
	
}
