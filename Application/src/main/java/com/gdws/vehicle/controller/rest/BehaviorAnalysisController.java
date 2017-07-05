/*
 * File Name：BehaviorAnalysisController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午2:58:30
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
import com.gdws.vehicle.entity.CarCrossYearCntWithCrossInfo;
import com.gdws.vehicle.repository.CarCrossHourCntRepository;
import com.gdws.vehicle.repository.CarCrossYearCntRepository;
import com.gdws.vehicle.service.BehaviorAnalysisService;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午2:58:30
 */
@RestController
public class BehaviorAnalysisController {
//	@Autowired
//	private BehaviorAnalysisService service;
//
//	@Autowired
//	private CarCrossYearCntRepository carCrossYearCntRepository;
//
//	@RequestMapping("/analysisOnHour")
//	@ResponseBody
//	public JSONPObject analysisOnHour(String cb, String plateNo, String crossTime) {
//		JSONObject str = service.analysisOnDay(plateNo, crossTime);
//		return new JSONPObject(cb, str.toString());
//	}
//
//	/**
//	 * 最近n天(一个月、一周)的数据
//	 * 
//	 * @param day(7/30)
//	 * @param plateNo
//	 * @return
//	 */
//	@RequestMapping("/analysisOnWeek")
//	@ResponseBody
//	public JSONPObject analysisOnWeek(String cb, int day, String plateNo) {
//		JSONObject str = service.analysisOnWeek(day, plateNo);
//		return new JSONPObject(cb, str.toString());
//	}
//
//	@RequestMapping("analysisOnYear")
//	@ResponseBody
//	public JSONPObject analysisOnYear(String cb, String plateNo) {
//		JSONObject str = service.analysisOnYear(plateNo);
//		return new JSONPObject(cb, str.toString());
//	}
}
