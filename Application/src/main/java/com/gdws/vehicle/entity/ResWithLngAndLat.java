/*
 * File Name：ResWithLngAndLat.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年7月5日 下午4:27:06
 */
package com.gdws.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author vous (shinena_deng@163.com)
 * @version 1.0, 2017年7月5日 下午4:27:06
 */
@Entity
public class ResWithLngAndLat {
	@Id
	@GeneratedValue
	private int id;
	private String lng;
	private String lat;
	private int crossCnt;
	/** @return 返回{@link #id} */
	public int getId() {
		return id;
	}
	/** @param id 设置{@link #id} */
	public void setId(int id) {
		this.id = id;
	}
	/** @return 返回{@link #lng} */
	public String getLng() {
		return lng;
	}
	/** @param lng 设置{@link #lng} */
	public void setLng(String lng) {
		this.lng = lng;
	}
	/** @return 返回{@link #lat} */
	public String getLat() {
		return lat;
	}
	/** @param lat 设置{@link #lat} */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/** @return 返回{@link #crossCnt} */
	public int getCrossCnt() {
		return crossCnt;
	}
	/** @param crossCnt 设置{@link #crossCnt} */
	public void setCrossCnt(int crossCnt) {
		this.crossCnt = crossCnt;
	}

}
