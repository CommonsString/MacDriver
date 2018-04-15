package com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.domain.Cost;
import com.base.service.CostService;
import com.base.utils.JSONResultM;

/**
 * 班费公示
 *
 */

@Controller
public class CostController {
	
	@Autowired
	private CostService costService;
	
	
	public JSONResultM flushData(){
		
		return null;
	}
	
	/**
	 * 根据班级号，获取信息
	 * @param classNum
	 * @return 总额
	 */
	@RequestMapping("/details")
	@ResponseBody
	public JSONResultM costDetailsInfo(String classNum, String name){
		JSONResultM json = new JSONResultM();
		try {
			if(!"".equals(classNum) && classNum != null){
				int result = this.costService.getDetailIsExist(classNum);
				if(result <= 0){ //无数据创建数据
					Cost cost = new Cost();
					cost.setClassNum(classNum); //设置班级
					cost.setName(name); //设置姓名
					cost.setTime(new Date()); //设置时间
					this.costService.insertDetails(cost);
				}
				//返回最新的数据
				Cost cost = this.costService.getNewDateDetails(classNum);
				json.setCost(cost);
				return json;
			}
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
	

}
