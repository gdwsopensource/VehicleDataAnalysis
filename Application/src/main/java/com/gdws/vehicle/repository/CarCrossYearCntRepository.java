/*
 * File Name：CarCrossYearCntRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 下午3:19:36
 */
package com.gdws.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gdws.vehicle.entity.CarCrossYearCntWithCrossInfo;


/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 下午3:19:36
 */
public interface CarCrossYearCntRepository  extends JpaRepository<CarCrossYearCntWithCrossInfo, Long> {

	@Query(value="select cy.id as id, cy.plate_no as plate_no,cy.month_num as month_num,cy.cross_cnt as cross_cnt,ci.cross_name as cross_name from car_cross_year_cnt cy join cross_info ci on ci.cross_id=cy.cross_id where cy.plate_no=?1",nativeQuery=true)
	List<CarCrossYearCntWithCrossInfo> getOneYearData(String plateNo);
}
