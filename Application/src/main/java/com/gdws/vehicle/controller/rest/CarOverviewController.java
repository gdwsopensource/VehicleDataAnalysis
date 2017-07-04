/*
 * File Name：CarOverviewController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午1:50:54
 */
package com.gdws.vehicle.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdws.vehicle.service.CarOverviewService;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午1:50:54
 */
@RestController
public class CarOverviewController {
	@Autowired
	private CarOverviewService carOverviewService;

	/**
	 * 获取每日预警数据
	 * 
	 * @param crossTime
	 * @return
	 */
	
	@RequestMapping("/getCarOverview")
	@ResponseBody
	public JSONPObject getCarOverview(String cb,String crossTime) {
		JSONObject str = carOverviewService.getCrossOverview(crossTime);
		return new JSONPObject(cb, str.toString());
	}

}
