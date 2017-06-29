/*
 * File Name：CarOverview.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月27日 下午5:24:10
 */
package com.gdws.vehicle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月27日 下午5:24:10
 */
@Entity
public class CarOverview {
	@Id
	@GeneratedValue
	private int id;
	private int crossId;
	private int carCrossCnt;
	private String crossTime;
	private String comment1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCrossId() {
		return crossId;
	}
	public void setCrossId(int crossId) {
		this.crossId = crossId;
	}
	public int getCarCrossCnt() {
		return carCrossCnt;
	}
	public void setCarCrossCnt(int carCrossCnt) {
		this.carCrossCnt = carCrossCnt;
	}
	public String getCrossTime() {
		return crossTime;
	}
	public void setCrossTime(String crossTime) {
		this.crossTime = crossTime;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	
	
}
