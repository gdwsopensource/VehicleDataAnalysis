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
//	co.id,co.carCrossCnt,ci.longitude,ci.latitude
	private int id;
	private int carCrossCnt;
	private String longitude;
	private String latitude;

	public CrossOverview(){
		
	}
	
	/**
	 * @param id
	 * @param carCrossCnt
	 * @param longitude
	 * @param latitude
	 */
	public CrossOverview(int id, int carCrossCnt, String longitude, String latitude) {
		this.id = id;
		this.carCrossCnt = carCrossCnt;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcarCrossCnt() {
		return carCrossCnt;
	}
	public void setcarCrossCnt(int carCrossCnt) {
		this.carCrossCnt = carCrossCnt;
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
