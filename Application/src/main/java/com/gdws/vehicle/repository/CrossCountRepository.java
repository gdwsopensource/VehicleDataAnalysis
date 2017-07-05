/*
 * File Name：CrossCountRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月4日 下午4:19:53
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.CrossCount;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月4日 下午4:19:53
 */
public interface CrossCountRepository extends JpaRepository<CrossCount, Integer> {
	/**
	 * 
	 * @param crossTime
	 * @param plateNo
	 * @return
	 */
	@Query(value = "select ch.id as id,sum(ch.cross_cnt) as count,ch.cross_id as cross_id,ci.cross_name as cross_name from car_cross_hour_cnt ch join cross_info ci on ch.cross_id=ci.cross_id where cross_time=?1 and plate_no=?2 GROUP BY cross_id ORDER BY count(cross_cnt) desc LIMIT 6;", nativeQuery = true)
	List<CrossCount> getSixCross(String crossTime, String plateNo);
	
	@Query(value="select ch.id as id,sum(ch.cross_cnt) as count,ch.cross_id as cross_id,ci.cross_name as cross_name FROM car_cross_day_cnt ch left outer JOIN cross_info ci ON ch.cross_id = ci.cross_id WHERE date_sub(curdate(), INTERVAL 7 DAY) <= date(cross_time) AND plate_no = ?1 GROUP BY cross_id ORDER BY sum(cross_cnt) DESC LIMIT 6",nativeQuery=true)
	List<CrossCount> getOneWeek(String plateNo);
}
