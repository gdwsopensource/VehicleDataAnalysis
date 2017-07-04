/*
 * File Name：BehaviorAnalysisOneDayImpl.java
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

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月4日 下午4:38:04
 */
@Service
public class BehaviorAnalysisOneDayImpl {
	@Autowired
	private CrossCountRepository crossCountRepository;
	@Autowired
	private CarCrossHourCntRepository carCrossHourCntRepository;
	public JSONObject analysisOneDay(String crossTime, String plateNo){
		JSONObject obj=new JSONObject();
		List<CrossCount> crossCountList=crossCountRepository.getSixCross(crossTime, plateNo);
		Iterator<CrossCount> crossCountListIter=crossCountList.iterator();
		if(crossCountListIter.hasNext()){
			while(crossCountListIter.hasNext()){
				List<JSONObject> data=new ArrayList<JSONObject>();
				CrossCount crossCountTemp=crossCountListIter.next();
				List<CarCrossHourCnt> carCrossHourCntList=carCrossHourCntRepository.getOneDayAnalysis(crossTime, plateNo, crossCountTemp.getCrossId());
				
			}
		}
		return obj;
	}

}
