/*
 * File Name：BehaviorAnalysisOnWeekServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午2:39:44
 */
package com.gdws.vehicle.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarCrossDayCnt;
import com.gdws.vehicle.entity.CrossCount;
import com.gdws.vehicle.repository.CarCrossDayCntRepository;
import com.gdws.vehicle.repository.CrossCountRepository;
import com.gdws.vehicle.service.BehaviorAnalysisOnWeekService;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午2:39:44
 */
@Service
public class BehaviorAnalysisOnWeekServiceImpl implements BehaviorAnalysisOnWeekService {
	@Autowired
	private CrossCountRepository crossCountRepository;
	@Autowired
	private CarCrossDayCntRepository carCrossDayCntRepository;
	@Override
	public JSONObject analysisOnWeek(String plateNo) {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject();
		try{
			List<CrossCount> crossCountList=crossCountRepository.getOneWeek(plateNo);
			Iterator<CrossCount> crossCountListIter=crossCountList.iterator();
			if(crossCountListIter.hasNext()){
				List<JSONObject> data = new ArrayList<JSONObject>();
				while(crossCountListIter.hasNext()){
					CrossCount crossCountTemp=crossCountListIter.next();
					JSONObject tmpData = new JSONObject();
					List<CarCrossDayCnt> carCrossDayCntList=carCrossDayCntRepository.analysisOnWeek(plateNo, crossCountTemp.getCrossId());
					Iterator<CarCrossDayCnt> carCrossDayCntListIter=carCrossDayCntList.iterator();
					String[] week={"周一","周二","周三","周四","周五","周六","周日"};
					int[] count={0,0,0,0,0,0,0};
					while(carCrossDayCntListIter.hasNext()){
						CarCrossDayCnt tmp=carCrossDayCntListIter.next();
						count[Integer.parseInt(tmp.getWeekNum())-1]=tmp.getCrossCnt();
					}
					tmpData.put("cross_id", crossCountTemp.getCrossId());
					tmpData.put("cross_name",crossCountTemp.getCrossName());
					tmpData.put("week_time", week);
					tmpData.put("cross_car_data", count);
					tmpData.put("cross_car_total", carCrossDayCntList.size());
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
		}catch(Exception e){
			obj.put("code", 500);
			obj.put("message", "error");
			obj.put("total", 0);
			obj.put("data", null);
			e.printStackTrace();
		}
		return obj;
	}


}
