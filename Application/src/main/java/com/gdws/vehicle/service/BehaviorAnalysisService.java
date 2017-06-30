/*
 * File Name：BehaviorAnalysisService.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 上午11:00:11
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 上午11:00:11
 */
public interface BehaviorAnalysisService {
	/**
	 * 最近一天的行为分析
	 * @param plateNo
	 * @return
	 */
	public JSONObject analysisOnHour(String plateNo);
	
	/**
	 * 最近一周的行为分析
	 * @param plateNo
	 * @return
	 */
	public JSONObject analysisOnWeek(int day,String plateNo);
}
