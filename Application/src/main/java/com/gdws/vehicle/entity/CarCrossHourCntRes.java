/*
 * File Name：CarCrossHourCntRes.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月30日 下午4:30:46
 */
package com.gdws.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月30日 下午4:30:46
 */
@Entity
public class CarCrossHourCntRes {
	@Id
	@GeneratedValue
	private int id;
	private String plateNo;
	private String hourNum;
	private String crossId;
	private String crossTime;
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

	public String getHourNum() {
		return hourNum;
	}

	public void setHourNum(String hourNum) {
		this.hourNum = hourNum;
	}

	public String getCrossId() {
		return crossId;
	}

	public void setCrossId(String crossId) {
		this.crossId = crossId;
	}

	public String getCrossTime() {
		return crossTime;
	}

	public void setCrossTime(String crossTime) {
		this.crossTime = crossTime;
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
