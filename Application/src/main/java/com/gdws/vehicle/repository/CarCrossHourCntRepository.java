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
import com.gdws.vehicle.entity.CarCrossHourCntRes;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午2:39:34
 */
public interface CarCrossHourCntRepository extends JpaRepository<CarCrossHourCntRes, Long> {
	/**
	 * 最近一天行为分析
	 * 
	 * @param plateNo
	 * @return
	 */
	@Query(value = "select a.*,c.cross_name from( select  * from car_cross_hour_cnt a where  5>( select  count(*) from car_cross_hour_cnt  where hour_num=a.hour_num and  cross_id=a.cross_id and cross_cnt > a.cross_cnt  ) and a.plate_no=?1   and a.cross_time=?2 order by hour_num,cross_cnt) a left outer join cross_info c on a.cross_id=c.cross_id ;", nativeQuery = true)
	List<CarCrossHourCntRes> findByPlateNoOrderByCrossCntDesc(String plateNo,String crossTime);
}
