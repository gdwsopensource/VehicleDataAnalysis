/*
 * File Name：BehaviorPredictionController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月1日 下午5:03:57
 */
package com.gdws.vehicle.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdws.vehicle.service.BehaviorpredictionService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月1日 下午5:03:57
 */
@RestController
public class BehaviorPredictionController {
	@Autowired
	private BehaviorpredictionService service;

	@RequestMapping("behaviorPredict")
	@ResponseBody
	public JSONPObject behaviorPredict(String cb, String plateNo) {
		JSONObject str = service.behaviorPredict(plateNo);
		return new JSONPObject(cb, str.toString());
	}
}
