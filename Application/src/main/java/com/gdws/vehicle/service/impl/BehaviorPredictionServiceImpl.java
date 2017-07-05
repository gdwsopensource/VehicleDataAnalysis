/*
 * File Name：BehaviorPredictionServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月1日 下午4:49:24
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.BehaviorPrediction;
import com.gdws.vehicle.repository.BehaviorPredictionRepository;
import com.gdws.vehicle.service.BehaviorpredictionService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月1日 下午4:49:24
 */
@Service
public class BehaviorPredictionServiceImpl implements BehaviorpredictionService {
	@Autowired
	private BehaviorPredictionRepository behaviorPredictionRepository;

	@Override
	public JSONObject behaviorPredict(String plateNo) {
		JSONObject obj = new JSONObject();
		try {
			List<BehaviorPrediction> bp = behaviorPredictionRepository.behaviorPredict(plateNo);
			if (bp.size() > 0) {
				ArrayList arr = new ArrayList();
				for (int i = 0; i < bp.size(); i++) {
					JSONObject tmp = new JSONObject();
					tmp.put("id", bp.get(i).getId());
					tmp.put("cross_id", bp.get(i).getCrossId());
					tmp.put("cross_name", bp.get(i).getCrossName());
					tmp.put("plate_no", bp.get(i).getPlateNo());
					tmp.put("cross_time", bp.get(i).getCrossTime());
					tmp.put("alert_type", bp.get(i).getAlertType());
					arr.add(tmp);
				}
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", arr);
			} else {
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", "null");
			}
		} catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "failure");
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}

}
