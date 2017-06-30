/*
 * File Name：CarOverviewCrossController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 上午11:09:47
 */
package com.gdws.vehicle.controller.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.service.CarOverviewService;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 上午11:09:47
 */
@RestController
public class CarOverviewCrossController {
	@Autowired
	private CarOverviewService service;
	/**
	 * 获取卡过车信息
	 * @param crossName
	 * @param crossTime
	 * @return
	 */
	@RequestMapping("getCarOverviewCross")
	JSONObject getCarOverviewCross(@RequestParam("crossName") String crossName,@RequestParam("crossTime") String crossTime){
		return service.getCarOverviewCross(crossName, crossTime); 
	}
}
