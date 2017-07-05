/*
 * File Name：BehaviorAnalysisOnWeekService.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午2:38:27
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午2:38:27
 */
public interface BehaviorAnalysisOnWeekService {
	/**
	 * 
	 * @param plateNo
	 * @return
	 */
	public JSONObject analysisOnWeek(String plateNo);
}
