package com.base.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.domain.Student;

import net.sf.json.JSONArray;


/**
 * 匹配操作
 */
public class MatchTools {
	

	
	/**
	 * @param one 学生表总蓝牙地址集合
	 * @param two 签到学生表蓝牙地址
	 * @return
	 */
	public static List<Student> getUnsign(List<Student> allStu, List<Student> signStu){
		List<Student> result = null;
		if(!allStu.isEmpty() && !signStu.isEmpty()){
			allStu.removeAll(signStu);
			result = allStu;
		}
		return result;
	}
	
    /**
     * @param tempJson 
     * @return 转换成list
     */
	public static ArrayList<String> beList(String path){
		ArrayList<String> result = null;
		if(path != null){
			JSONArray tempJson = JSONArray.fromObject(path);
			String[] arr = (String[]) JSONArray.toArray(tempJson);
			result = new ArrayList<String>(Arrays.asList(arr));
			return result;
		}
		return result;
	}
	
}
