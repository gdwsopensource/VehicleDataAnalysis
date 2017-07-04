/*
 * File Name：BehaviorAnalysisOneDay.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月4日 下午4:26:59
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月4日 下午4:26:59
 */
public interface BehaviorAnalysisOneDay {
	/**
	 * 一天的行为分析
	 * 
	 * @param crossTime
	 * @param plateNo
	 * @return
	 */
	public JSONObject analysisOneDay(String crossTime, String plateNo);
}
