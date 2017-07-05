/*
 * File Name：BehaviorAnalysisOneDayController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 上午10:48:47
 */
package com.gdws.vehicle.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdws.vehicle.entity.CrossCount;
import com.gdws.vehicle.service.BehaviorAnalysisOneDayService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 上午10:48:47
 */
@RestController
public class BehaviorAnalysisOneDayController {
	@Autowired
	private BehaviorAnalysisOneDayService service;

	@RequestMapping("analysisOneDay")
	@ResponseBody
	public JSONPObject analysisOneDay(String cb, String crossTime, String plateNo) {
		JSONObject str = service.analysisOneDay(crossTime,  plateNo);
		return new JSONPObject(cb, str.toString());
	}


}
