/*
 * File Name：CarOverviewCrossRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 上午9:42:20
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.CarOverviewCross;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 上午9:42:20
 */
public interface CarOverviewCrossRepository extends JpaRepository<CarOverviewCross, Integer> {

	/**
	 * 根据卡口和时间获取交通概览详细信息
	 * 
	 * @return
	 */

	@Query(value = "select co.id as id,co.cross_id as cross_id,co.plate_no as plate_no,co.cross_time as cross_time,co.hour_num as hour_num,co.alert_type as alert_type,co.comment1 as comment1 from car_overview_cross co join black_list bl on co.plate_no=bl.plate_no where co.cross_id=?1 and co.cross_time=?2  ORDER BY hour_num", nativeQuery = true)
	List<CarOverviewCross> findByCrossAndDate(String crossId, String crossTime);
	
}
