/*
 * File Name：BehaviorAnalysisOnMonthController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午4:35:11
 */
package com.gdws.vehicle.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdws.vehicle.entity.ResWithLngAndLat;
import com.gdws.vehicle.service.BehaviorAnalysisOnMonthService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午4:35:11
 */
@RestController
public class BehaviorAnalysisOnMonthController {
	@Autowired
	private BehaviorAnalysisOnMonthService behaviorAnalysisOnMonthService;

	@RequestMapping("analysisOnMonth")
	@ResponseBody
	public JSONPObject analysisOnMonth(String cb, String plateNo) {
		JSONObject str = behaviorAnalysisOnMonthService.analysisOnMonth(plateNo);
		return new JSONPObject(cb, str.toString());
	}
}
