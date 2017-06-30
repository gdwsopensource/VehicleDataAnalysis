/*
 * File Name：CarOverviewCross.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 上午9:27:30
 */
package com.gdws.vehicle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 上午9:27:30
 */
@Entity
public class CarOverviewCross {
	@Id
	@GeneratedValue
	private int id;
	private String crossId;
	private String plateNo;
	private String crossTime;
	private String hourNum;
	private String alertType;
	private String comment1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public String getCrossId() {
		return crossId;
	}

	public void setCrossId(String crossId) {
		this.crossId = crossId;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getCrossTime() {
		return crossTime;
	}

	public void setCrossTime(String crossTime) {
		this.crossTime = crossTime;
	}

	public String getHourNum() {
		return hourNum;
	}

	public void setHourNum(String hourNum) {
		this.hourNum = hourNum;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

}
