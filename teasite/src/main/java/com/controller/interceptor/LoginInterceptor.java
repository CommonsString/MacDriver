package com.controller.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.base.utils.JSONResult;

import net.sf.json.JSONObject;

/**
 * 预留
 * springmvc拦截器
 * 权限控制
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//处理逻辑
		if(handler instanceof HandlerMethod){ //类型为请求方法
			HandlerMethod method = (HandlerMethod) handler;
			MustLogin ml = method.getMethodAnnotation(MustLogin.class); //获取注解下---获取注解下的方法
			if(ml != null){
				//response流返回json数据
				JSONResult json = new JSONResult(false, "EX:CONTINUE FINDING!");
				JSONObject jsonObj = JSONObject.fromObject(json); //转换成json
				response.setContentType("application/json; charset=utf-8");
				response.setCharacterEncoding("UTF-8"); 
				PrintWriter  out = response.getWriter();
				out.write(jsonObj.toString());
				out.flush(); //刷新流
				return false; //阻止执行所有程序
			}
		}
		return super.preHandle(request, response, handler);
	}
	
}
