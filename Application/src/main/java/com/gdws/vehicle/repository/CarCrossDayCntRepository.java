/*
 * File Name：CarCrossDayCntRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 下午12:48:04
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.CarCrossDayCnt;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 下午12:48:04
 */
public interface CarCrossDayCntRepository extends JpaRepository<CarCrossDayCnt, Integer> {
	CarCrossDayCnt findById(int id);

	/**
	 * 获取最近n天的数据(一周、一个月)
	 * 
	 * @param day
	 * @param plateNo
	 * @return
	 */

	@Query(value = "SELECT * from car_cross_day_cnt where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(cross_time) AND plate_no = ?1 and cross_id=?2  ORDER BY week_num asc;", nativeQuery = true)
	List<CarCrossDayCnt> analysisOnWeek(String plateNo, String crossId);
}
