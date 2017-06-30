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
import com.gdws.vehicle.entity.CarCrossDayCnt;
import com.gdws.vehicle.entity.CarCrossHourCnt;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午2:39:34
 */
public interface CarCrossHourCntRepository extends JpaRepository<CarCrossHourCnt, Long> {
	/**
	 * @param plateNo
	 * @return
	 */
	// select * from car_cross_hour_cnt where plate_no=?1 GROUP BY cross_id
	// ORDER BY cross_cnt DESC LIMIT 5
	@Query(value = "select * from car_cross_hour_cnt where plate_no=?1 ORDER BY cross_cnt DESC;", nativeQuery = true)
	List<CarCrossHourCnt> findByPlateNoOrderByCrossCntDesc(String plateNo);
}
