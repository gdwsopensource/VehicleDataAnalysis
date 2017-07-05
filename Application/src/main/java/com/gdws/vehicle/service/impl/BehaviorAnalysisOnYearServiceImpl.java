/*
 * File Name：BehaviorAnalysisOnYearServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午6:52:12
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.ResWithLngAndLat;
import com.gdws.vehicle.repository.BehaviorAnalysisOnYearRepository;
import com.gdws.vehicle.service.BehaviorAnalysisOnYearService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午6:52:12
 */
@Service
public class BehaviorAnalysisOnYearServiceImpl implements BehaviorAnalysisOnYearService{
@Autowired
private BehaviorAnalysisOnYearRepository behaviorAnalysisOnYearRepository;
	@Override
	public JSONObject analysisOnYear(String plateNo) {
		// TODO Auto-generated method stub
		JSONObject obj =new JSONObject();
		try{
			List<ResWithLngAndLat> list = behaviorAnalysisOnYearRepository.analysisOnYear(plateNo);
			Iterator<ResWithLngAndLat> listIter = list.iterator();
			if (listIter.hasNext()) {
				List<JSONObject> data = new ArrayList<JSONObject>();
				while (listIter.hasNext()) {
					ResWithLngAndLat res = listIter.next();
					JSONObject tmp = new JSONObject();
					// String[] arr = { res.getLng(),res.getLat() };
					Double[] arr = new Double[2];
					//check the lng and lat value ,if not valid, return default value.
					if(res.getLng()!=null && res.getLat()!=null ){
						arr[0] = Double.parseDouble(res.getLng());
						arr[1] = Double.parseDouble(res.getLat());
					}
					else{
						arr[0] = 113.0;
						arr[1] = 23.0;
					}
					tmp.put("coord", arr);
					tmp.put("elevation", res.getCrossCnt());
					data.add(tmp);
				}
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", data);

			} else {
				obj.put("code", 200);
				obj.put("message", "success");
				obj.put("data", "null");
			}
		}catch (Exception e) {
			obj.put("code", 500);
			obj.put("message", "error");
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}

}
