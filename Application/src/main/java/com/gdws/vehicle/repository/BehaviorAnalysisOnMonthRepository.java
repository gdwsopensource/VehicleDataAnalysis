/*
 * File Name：BehaviorAnalysisOnMonthRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午4:29:14
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.ResWithLngAndLat;


/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午4:29:14
 */
public interface BehaviorAnalysisOnMonthRepository extends JpaRepository<ResWithLngAndLat, Integer> {

	@Query(value="select a.id as id,a.cross_cnt,b.lng,b.lat from( select * from car_cross_day_cnt WHERE date_sub(curdate(), INTERVAL 30 DAY) <= date(cross_time) AND plate_no = ?1) a inner join(SELECT ch.id AS id,sum(ch.cross_cnt) AS sum_cnt,ch.cross_id AS cross_id,ci.cross_name AS cross_name,ci.longitude as lng,ci.latitude as lat FROM car_cross_day_cnt ch left outer JOIN cross_info ci ON ch.cross_id = ci.cross_id WHERE date_sub(curdate(), INTERVAL 30 DAY) <= date(cross_time) AND plate_no = ?1 GROUP BY cross_id ORDER BY sum(cross_cnt) DESC LIMIT 6) b on a.cross_id=b.cross_id;",nativeQuery=true)
	List<ResWithLngAndLat> analysisOnMonth(String plateNo);
}
