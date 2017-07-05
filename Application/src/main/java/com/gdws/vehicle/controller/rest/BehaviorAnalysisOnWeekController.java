/*
 * File Name：BehaviorAnalysisOnWeekController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午3:38:28
 */
package com.gdws.vehicle.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdws.vehicle.entity.CarCrossDayCnt;
import com.gdws.vehicle.entity.CrossCount;
import com.gdws.vehicle.repository.CarCrossDayCntRepository;
import com.gdws.vehicle.repository.CrossCountRepository;
import com.gdws.vehicle.service.BehaviorAnalysisOnWeekService;


/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午3:38:28
 */
@RestController
public class BehaviorAnalysisOnWeekController {
	@Autowired
	private BehaviorAnalysisOnWeekService service;
	
	@RequestMapping("analysisOnWeek")
	@ResponseBody
	public JSONPObject analysisOnWeek(String cb, String plateNo) {
		JSONObject str = service.analysisOnWeek(plateNo);
		return new JSONPObject(cb, str.toString());
	}
	@Autowired
	private CarCrossDayCntRepository carCrossDayCntRepository;
@RequestMapping("test")
List<CarCrossDayCnt> test(String plateNo,String crossId){
	return carCrossDayCntRepository.analysisOnWeek(plateNo, crossId);
}
	 
}
