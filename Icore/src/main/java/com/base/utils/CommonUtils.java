package com.base.utils;

import org.springframework.util.DigestUtils;

/**
 * 工具集
 */
public class CommonUtils {
	
	
	/**
	 * MD5加密，每次登录需要加密后与数据库比对
	 * @param password
	 * @return 加密后的密码
	 */
	public static String MD5(String password){
		if(password != null && !"".equals(password)){
			return DigestUtils.md5DigestAsHex(password.getBytes());
		}
		return password;
	}

}
