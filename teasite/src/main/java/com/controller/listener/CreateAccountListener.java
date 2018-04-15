package com.controller.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;



/**

 * 初始化账号信息
 *
 */

public class CreateAccountListener implements ApplicationListener<ContextRefreshedEvent>{

//	@Autowired
//	private TeacherService teaService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		this.teaService.initAccount();
	}
}