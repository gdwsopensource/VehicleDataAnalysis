/*
 * File Name：BehaviorAnalysisOneDayServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月4日 下午4:38:04
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarCrossHourCnt;
import com.gdws.vehicle.entity.CrossCount;
import com.gdws.vehicle.repository.CarCrossHourCntRepository;
import com.gdws.vehicle.repository.CrossCountRepository;
import com.gdws.vehicle.service.BehaviorAnalysisOneDayService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月4日 下午4:38:04
 */
@Service
public class BehaviorAnalysisOneDayServiceImpl implements BehaviorAnalysisOneDayService {
	@Autowired
	private CrossCountRepository crossCountRepository;
	@Autowired
	private CarCrossHourCntRepository carCrossHourCntRepository;

	@Override
	public JSONObject analysisOneDay(String crossTime, String  plateNo) {
		JSONObject obj = new JSONObject();
		try {
			List<CrossCount> crossCountList = crossCountRepository.getSixCross(crossTime, plateNo);
			Iterator<CrossCount> crossCountListIter = crossCountList.iterator();
			if (crossCountListIter.hasNext()) {
				List<JSONObject> data = new ArrayList<JSONObject>();
				while (crossCountListIter.hasNext()) {
					JSONObject tmpData = new JSONObject();
					CrossCount crossCountTemp = crossCountListIter.next();
					List<CarCrossHourCnt> carCrossHourCntList = carCrossHourCntRepository.getOneDayAnalysis(crossTime,
							plateNo, crossCountTemp.getCrossId());
					Iterator<CarCrossHourCnt> carCrossHourCntListIter = carCrossHourCntList.iterator();
					List<String> hourTemp = new ArrayList<String>();
					List<Integer> countTemp = new ArrayList<Integer>();
					for (int i = 0; i < 24; i++) {
						if (i < 10) {
							hourTemp.add("0" + i + ":00-" + "0" + i + ":59");
						} else {
							hourTemp.add(i + ":00-" + i + ":59");
						}
						countTemp.add(0);
					}
					while (carCrossHourCntListIter.hasNext()) {
						CarCrossHourCnt tmp=carCrossHourCntListIter.next();
						hourTemp.set(Integer.parseInt(tmp.getHourNum()),
								tmp.getHourNum()+":00-"+tmp.getHourNum()+":59");
						countTemp.set(Integer.parseInt(tmp.getHourNum()),
								tmp.getCrossCnt());
					}
					tmpData.put("cross_id", crossCountTemp.getCrossId());
					tmpData.put("cross_name", crossCountTemp.getCrossName());
					tmpData.put("day_time", hourTemp);
					tmpData.put("cross_car_data", countTemp);
					data.add(tmpData);
				}
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("total", crossCountList.size());
				obj.put("data", data);
			} else {
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("total", 0);
				obj.put("data", "null");
			}
		} catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "error");
			obj.put("total", 0);
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}

}
