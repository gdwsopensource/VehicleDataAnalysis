/*
 * File Name：BehaviorAnalysisServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 上午11:02:45
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarCrossDayCnt;
import com.gdws.vehicle.entity.CarCrossHourCnt;
import com.gdws.vehicle.entity.CrossInfo;
import com.gdws.vehicle.repository.CarCrossDayCntRepository;
import com.gdws.vehicle.repository.CarCrossHourCntRepository;
import com.gdws.vehicle.repository.CrossInfoRepository;
import com.gdws.vehicle.service.BehaviorAnalysisService;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 上午11:02:45
 */
@Service
public class BehaviorAnalysisServiceImpl implements BehaviorAnalysisService {
	@Autowired
	private CarCrossHourCntRepository carCrossHourCntRepository;
	@Autowired
	private CrossInfoRepository crossInfoRepository;
	@Autowired
	private CarCrossDayCntRepository carCrossDayCntRepository;

	@Override
	public JSONObject analysisOnHour(String plateNo) {
		JSONObject obj = new JSONObject();
		ArrayList arr = new ArrayList();
		try {
			List<CarCrossHourCnt> ch = carCrossHourCntRepository.findByPlateNoOrderByCrossCntDesc(plateNo);
			for (int i = 0; i < ch.size(); i++) {
				CrossInfo ci = crossInfoRepository.findByCrossId(ch.get(i).getCrossId());
				JSONObject tmp = new JSONObject();
				tmp.put("id", ch.get(i).getId());
				tmp.put("cross_name", ci.getCrossName());
				tmp.put("hour_num", ch.get(i).getHourNum());
				tmp.put("cross_cnt", ch.get(i).getCrossCnt());
				tmp.put("comment1", ch.get(i).getComment1());
				arr.add(tmp);
			}
			obj.put("code", 200);
			obj.put("message", "success");
			obj.put("data", arr);
		} catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "failure");
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public JSONObject analysisOnWeek(int day, String plateNo) {
		JSONObject obj = new JSONObject();
		ArrayList arr = new ArrayList();
		try {
			List<CarCrossDayCnt> cd = carCrossDayCntRepository.getOneWeekData(day, plateNo);
			for (int i = 0; i < cd.size(); i++) {
				CrossInfo ci = crossInfoRepository.findByCrossId(cd.get(i).getCrossId());
				JSONObject tmp = new JSONObject();
				tmp.put("id", cd.get(i).getId());
				// tmp.put("cross_name", cd.get(i).getCrossId());
				tmp.put("cross_name", ci.getCrossName());
				tmp.put("cross_time", cd.get(i).getCrossTime());
				tmp.put("week_num", cd.get(i).getWeekNum());
				tmp.put("cross_cnt", cd.get(i).getCrossCnt());
				tmp.put("comment1", cd.get(i).getComment1());
				arr.add(tmp);
			}
			obj.put("code", 200);
			obj.put("message", "success");
			obj.put("data", arr);
		} catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "failure");
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}
}
