/*
 * File Name：CarOverviewServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午4:05:54
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarOverview;
import com.gdws.vehicle.entity.CarOverviewCross;
import com.gdws.vehicle.entity.CrossInfo;
import com.gdws.vehicle.entity.CrossOverview;
import com.gdws.vehicle.repository.CarOverviewCrossRepository;
import com.gdws.vehicle.repository.CarOverviewRepository;
import com.gdws.vehicle.repository.CrossInfoRepository;
import com.gdws.vehicle.service.CarOverviewService;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午4:05:54
 */
@Service
public class CarOverviewServiceImpl implements CarOverviewService {
	@Autowired
	private CarOverviewRepository carOverviewRepository;
	@Autowired
	private CrossInfoRepository crossInfoRepository;
	@Autowired
	private CarOverviewCrossRepository carOverviewCrossRepository;

	@Override
	public JSONObject getCrossOverview(String crossTime) {
		JSONObject obj = new JSONObject();
		ArrayList list = new ArrayList();
		try {
			List<CarOverview> co = carOverviewRepository.getCarOverview(crossTime);
			for (int i = 0; i < co.size(); i++) {
				JSONObject tmp = new JSONObject();
				int crossId = co.get(i).getCrossId();
				CrossInfo ci = crossInfoRepository.findByCrossId(crossId);
				String str = null;
				if (co.get(i).getCarCrossCnt() > 10) {
					str = "serious";
				} else if (co.get(i).getCarCrossCnt() < 5) {
					str = "medium";
				} else {
					str = "low";
				}
				tmp.put("id", co.get(i).getId());
				tmp.put("car_cross_cnt", co.get(i).getCarCrossCnt());
				tmp.put("alert_type", str);
				tmp.put("lng", ci.getLongitude());
				tmp.put("lat", ci.getLatitude());
				list.add(tmp);
			}
			obj.put("data", list);
			obj.put("code", 200);
			obj.put("message", "success");
		} catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "failure");
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public JSONObject getCarOverviewCross(String crossName, String crossTime) {
		JSONObject obj = new JSONObject();
		ArrayList arr = new ArrayList();

		try {
			CrossInfo ci = crossInfoRepository.findByCrossName(crossName);
			List<CarOverviewCross> list = carOverviewCrossRepository.findByCrossAndDate(ci.getCrossId(), crossTime);

			for (int i = 0; i < list.size(); i++) {
				JSONObject tmp = new JSONObject();
				tmp.put("id", list.get(i).getId());
				tmp.put("cross_name", crossName);
				tmp.put("plate_no", list.get(i).getPlateNo());
				tmp.put("cross_time", list.get(i).getCrossTime());
				tmp.put("hour_num", list.get(i).getHourNum());
				tmp.put("alert_type", list.get(i).getAlertType());
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
