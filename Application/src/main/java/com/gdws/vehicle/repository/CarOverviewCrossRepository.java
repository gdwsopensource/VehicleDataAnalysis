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
public interface CarOverviewCrossRepository extends JpaRepository<CarOverviewCross, Long> {
	
	/**
	 * 根据卡口和时间获取交通概览详细信息
	 * @return
	 */
	
	@Query(value="select co.id,ci.cross_name,co.plate_no,co.hour_num,co.alert_type from car_overview_cross co join cross_info ci on co.cross_id=ci.cross_id where ci.cross_name=?1 and co.cross_time=?2",nativeQuery=true)
	List<Object> findByCrossAndDate(String crossName,String crossTime);
}
