/*
 * File Name：CarCrossHourCntRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午2:39:34
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.entity.CarCrossHourCnt;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午2:39:34
 */
public interface CarCrossHourCntRepository extends JpaRepository<CarCrossHourCnt, Integer> {
	/**
	 * 最近一天行为分析
	 * 
	 * @param plateNo
	 * @return
	 */
	@Query(value="SELECT * from car_cross_hour_cnt where cross_time=?1 and plate_no=?2 and cross_id=?3 ORDER BY hour_num asc",nativeQuery=true)
	List<CarCrossHourCnt> getOneDayAnalysis(String crossTime,String plateNo,String crossId);
}
