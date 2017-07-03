/*
 * File Name：BehaviorAnalysisService.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 上午11:00:11
 */
package com.gdws.vehicle.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarCrossHourCntRes;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 上午11:00:11
 */
public interface BehaviorAnalysisService {

	/**
	 * 最近一周的行为分析
	 * 
	 * @param plateNo
	 * @return
	 */
	public JSONObject analysisOnWeek(int day, String plateNo);

	/**
	 * @param plateNo
	 * @return
	 */
	JSONObject analysisOnYear(String plateNo);

	/**
	 * @param plateNo
	 * @param crossTime
	 * @return
	 */
	JSONObject analysisOnDay(String plateNo, String crossTime);
}
