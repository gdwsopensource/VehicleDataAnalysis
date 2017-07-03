/*
 * File Name：BehaviorPredictionRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月1日 下午3:09:26
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.BehaviorPrediction;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月1日 下午3:09:26
 */
public interface BehaviorPredictionRepository extends JpaRepository<BehaviorPrediction, Long> {
	/**
	 * 行为预测
	 * 
	 * @param plateNo
	 * @return
	 */
	@Query(value = "select co.id as id,co.cross_id as cross_id,ci.cross_name as cross_name,co.plate_no as plate_no,co.cross_time as cross_time ,co.alert_type as alert_type from car_overview_cross co join cross_info ci on co.cross_id=ci.cross_id where co.plate_no=?1", nativeQuery = true)
	List<BehaviorPrediction> behaviorPredict(String plateNo);
}
