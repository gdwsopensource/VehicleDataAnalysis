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
import com.gdws.vehicle.entity.CarCrossHourCntRes;
import com.gdws.vehicle.entity.CarCrossYearCntWithCrossInfo;
import com.gdws.vehicle.entity.CrossInfo;
import com.gdws.vehicle.repository.CarCrossDayCntRepository;
import com.gdws.vehicle.repository.CarCrossHourCntRepository;
import com.gdws.vehicle.repository.CarCrossYearCntRepository;
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
	@Autowired
	private CarCrossYearCntRepository carCrossYearCntRepository;

	@Override
	public JSONObject analysisOnDay(String plateNo, String crossTime) {
		JSONObject obj = new JSONObject();
		try {
			List<CarCrossHourCntRes> ch = carCrossHourCntRepository.findByPlateNoOrderByCrossCntDesc(plateNo, crossTime);
			if (ch.size() > 0) {
				ArrayList arr = new ArrayList();
				for (int i = 0; i < ch.size(); i++) {
					JSONObject tmp = new JSONObject();
					tmp.put("id", ch.get(i).getId());
					tmp.put("cross_id", ch.get(i).getCrossId());
					tmp.put("cross_time", ch.get(i).getCrossTime());
					tmp.put("cross_cnt", ch.get(i).getCrossCnt());
					tmp.put("cross_name", ch.get(i).getCrossName());
					tmp.put("hour_num", ch.get(i).getHourNum());
					tmp.put("plate_no", ch.get(i).getPlateNo());
					arr.add(tmp);
				}
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", arr);
			} else {
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", "no data");
			}
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
				tmp.put("cross_name", ci.getCrossName());
				tmp.put("cross_id", ci.getCrossId());
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

	@Override
	public JSONObject analysisOnYear(String plateNo) {
		JSONObject obj = new JSONObject();
		try {
			List<CarCrossYearCntWithCrossInfo> cy = carCrossYearCntRepository.getOneYearData(plateNo);
			if (cy.size() > 0) {
				ArrayList arr = new ArrayList();
				for (int i = 0; i < cy.size(); i++) {
					JSONObject tmp = new JSONObject();
					tmp.put("id", cy.get(i).getId());
					tmp.put("plate_no", cy.get(i).getPlateNo());
					tmp.put("month_num", cy.get(i).getMonthNum());
					tmp.put("cross_cnt", cy.get(i).getCrossCnt());
					tmp.put("cross_name", cy.get(i).getCrossName());
					arr.add(tmp);
				}
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", arr);
			} else {
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", "no data");
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
