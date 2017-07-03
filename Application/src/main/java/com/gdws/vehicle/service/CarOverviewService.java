/*
 * File Name：CarOverviewService.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午4:01:40
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CrossOverview;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午4:01:40
 */
public interface CarOverviewService {
	/**
	 * 获取概览信息
	 * 
	 * @param crossTime
	 * @return
	 */
	public JSONObject getCrossOverview(String crossTime);

	/**
	 * 获取卡口过车信息
	 * 
	 * @param crossName
	 * @param crossTime
	 * @return
	 */
	public JSONObject getCarOverviewCross(String crossName, String crossTime);
}
