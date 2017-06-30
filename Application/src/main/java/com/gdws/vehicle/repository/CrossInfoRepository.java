/*
 * File Name：CrossInfoRepository.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 上午10:06:44
 */
package com.gdws.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdws.vehicle.entity.CrossInfo;


/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 上午10:06:44
 */
public interface CrossInfoRepository extends JpaRepository<CrossInfo,Long>{
	/**
	 * 
	 * @param crossId
	 * @return
	 */
	CrossInfo findByCrossId(int crossId);
	
	/**
	 * 
	 * @param crossName
	 * @return
	 */
	CrossInfo findByCrossName(String crossName);
}
