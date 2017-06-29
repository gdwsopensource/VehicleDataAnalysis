/*
 * File Name：CarOverviewController.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午1:50:54
 */
package com.gdws.vehicle.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdws.vehicle.entity.CarOverview;
import com.gdws.vehicle.entity.CrossOverview;
import com.gdws.vehicle.repository.CarOverviewRepository;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午1:50:54
 */
@RestController
public class CarOverviewController {
	@Autowired
	private CarOverviewRepository carOverviewRepository;
	
	
	/**
	 * 获取每日预警数据
	 * @param crossTime
	 * @return
	 */
	@RequestMapping("getOverviewData")
	List<CarOverview> getOverviewDataByDate(@RequestParam("crossTime") String crossTime) {
		//List<String> test = carOverviewRepository.getOverviewData(crossTime);
		return carOverviewRepository.getOverviewData(crossTime);
	}

}
