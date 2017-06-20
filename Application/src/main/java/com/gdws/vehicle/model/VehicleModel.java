/*
 * File Name：VehicleModel.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月20日 下午9:38:40
 */
package com.gdws.vehicle.model;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月20日 下午9:38:40
 */
public class VehicleModel {
    private int vehicleId;
    private String vehiclePlateNo;
    private String vehicleType;
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }
    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}

