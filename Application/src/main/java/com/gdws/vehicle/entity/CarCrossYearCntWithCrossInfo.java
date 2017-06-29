/*
 * File Name：CarCrossYearCntWithCrossInfo.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月29日 下午3:22:10
 */
package com.gdws.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月29日 下午3:22:10
 */
@Entity
public class CarCrossYearCntWithCrossInfo {
	@Id
	@GeneratedValue
	private int id;
	private String plateNo;
	private String monthNum;
//	private String dateMonth;
	private int crossCnt;
	private String crossName;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(String monthNum) {
		this.monthNum = monthNum;
	}


	public int getCrossCnt() {
		return crossCnt;
	}

	public void setCrossCnt(int crossCnt) {
		this.crossCnt = crossCnt;
	}


	public String getCrossName() {
		return crossName;
	}

	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}


}
