/*
 * File Name：BehaviorpredictionService.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月1日 下午4:46:41
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月1日 下午4:46:41
 */
public interface BehaviorpredictionService {
	public JSONObject behaviorPredict(String plateNo);
}
