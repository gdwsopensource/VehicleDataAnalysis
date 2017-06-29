/*
 * File Name：CarCrossHourCnt.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 上午9:37:55
 */
package com.gdws.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 上午9:37:55
 */
@Entity
public class CarCrossHourCnt {
	@Id
	@GeneratedValue
	private int id;
	private String plateNo;
	private String hourNo;
	private int cross_id;
	private int crossCnt;
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
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getHourNo() {
		return hourNo;
	}
	public void setHourNo(String hourNo) {
		this.hourNo = hourNo;
	}
	
	public int getCross_id() {
		return cross_id;
	}
	public void setCross_id(int cross_id) {
		this.cross_id = cross_id;
	}
	public int getCrossCnt() {
		return crossCnt;
	}
	public void setCrossCnt(int crossCnt) {
		this.crossCnt = crossCnt;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

}
