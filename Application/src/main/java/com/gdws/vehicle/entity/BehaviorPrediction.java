/*
 * File Name：BehaviorPrediction.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月1日 下午4:39:08
 */
package com.gdws.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月1日 下午4:39:08
 */
@Entity
public class BehaviorPrediction {
	@Id
	@GeneratedValue
	private int id;
	private String crossId;
	private String crossName;
	private String plateNo;
	private String crossTime;
	private String alertType;

	/** @return 返回{@link #id} */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            设置{@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** @return 返回{@link #crossId} */
	public String getCrossId() {
		return crossId;
	}

	/**
	 * @param crossId
	 *            设置{@link #crossId}
	 */
	public void setCrossId(String crossId) {
		this.crossId = crossId;
	}

	/** @return 返回{@link #crossName} */
	public String getCrossName() {
		return crossName;
	}

	/**
	 * @param crossName
	 *            设置{@link #crossName}
	 */
	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}

	/** @return 返回{@link #plateNo} */
	public String getPlateNo() {
		return plateNo;
	}

	/**
	 * @param plateNo
	 *            设置{@link #plateNo}
	 */
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	/** @return 返回{@link #crossTime} */
	public String getCrossTime() {
		return crossTime;
	}

	/**
	 * @param crossTime
	 *            设置{@link #crossTime}
	 */
	public void setCrossTime(String crossTime) {
		this.crossTime = crossTime;
	}

	/** @return 返回{@link #alertType} */
	public String getAlertType() {
		return alertType;
	}

	/**
	 * @param alertType
	 *            设置{@link #alertType}
	 */
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

}
