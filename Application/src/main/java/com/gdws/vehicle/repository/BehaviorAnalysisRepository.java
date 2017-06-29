/*
 * File Name：BehaviorAnalysisRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午2:39:34
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.CarCrossHourCnt;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午2:39:34
 */
public interface BehaviorAnalysisRepository extends JpaRepository<CarCrossHourCnt,Long>{
	/**
	 * 最近一天的行为分析
	 * @param plateNo
	 * @return
//	 */
//	@Query(value="select  from car_cross_hour_cnt cc join  where plate_no=?1",nativeQuery=true)
////	List<Object> getLastDayAct(String plateNo);
}
