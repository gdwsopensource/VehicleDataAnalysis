/*
 * File Name：CrossOverview.java
 *
 * Copyrighe：copyright@2017 GZSW Company, All Rights Reserved
 *
 * Create Time: 2017年6月28日 下午4:38:57
 */
package com.gdws.vehicle.entity;

/**
 *
 * @author Administrator (shinena_deng@163.com)
 * @version 1.0, 2017年6月28日 下午4:38:57
 */
public class CrossOverview {
//	co.id,co.car_cross_cnt,ci.longitude,ci.latitude
	private int id;
	private int car_cross_cnt;
	private String longitude;
	private String latitude;

	public CrossOverview(){
		
	}
	
	/**
	 * @param id
	 * @param car_cross_cnt
	 * @param longitude
	 * @param latitude
	 */
	public CrossOverview(int id, int car_cross_cnt, String longitude, String latitude) {
		this.id = id;
		this.car_cross_cnt = car_cross_cnt;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCar_cross_cnt() {
		return car_cross_cnt;
	}
	public void setCar_cross_cnt(int car_cross_cnt) {
		this.car_cross_cnt = car_cross_cnt;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}
