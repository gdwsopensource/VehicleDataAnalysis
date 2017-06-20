
/**
 * create database
 */
DROP DATABASE IF EXISTS vehicleanalysis;
CREATE DATABASE vehicleanalysis;

/*
 * create tables
 * 
 */
DROP TABLE IF EXISTS camera_record;
CREATE TABLE `camera_record` (
  `id` int(11) NOT NULL,
  `vehicle_plate_no` char(12) DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  `camera_no` int(11) DEFAULT NULL,
  `camera_name` varchar(255) DEFAULT NULL COMMENT '卡口名称',
  `alarm_type` varchar(255) DEFAULT NULL,
  `alarm_time` datetime DEFAULT NULL,
  `pass_time` datetime DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS plate_cross;
CREATE TABLE `plate_cross` (
  `PASS_ID` decimal(15,0) NOT NULL,
  `CROSSING_ID` decimal(10,0) DEFAULT NULL,
  `LANE_NO` decimal(5,0) DEFAULT NULL,
  `DIRECTION_INDEX` decimal(2,0) DEFAULT NULL,
  `PLATE_NO` varchar(20) DEFAULT NULL,
  `PLATE_TYPE` varchar(10) DEFAULT NULL,
  `PASS_TIME` datetime(6) DEFAULT NULL,
  `VEHICLE_SPEED` decimal(5,0) DEFAULT NULL,
  `VEHICLE_LEN` decimal(5,0) DEFAULT NULL,
  `PLATE_COLOR` varchar(10) DEFAULT NULL,
  `VEHICLE_COLOR` varchar(10) DEFAULT NULL,
  `VEHICLE_TYPE` varchar(10) DEFAULT NULL,
  `VEHICLE_COLOR_DEPTH` varchar(10) DEFAULT NULL,
  `PLATE_STATE` varchar(10) DEFAULT NULL,
  `IMAGE_PATH` text,
  `PLATE_IMAGE_PATH` text,
  `TFS_ID` decimal(10,0) DEFAULT NULL,
  `VEHICLE_STATE` decimal(10,0) DEFAULT NULL,
  `RES_NUM1` decimal(65,30) DEFAULT NULL,
  `RES_NUM2` decimal(65,30) DEFAULT NULL,
  `RES_STR3` varchar(64) DEFAULT NULL,
  `RES_STR4` varchar(64) DEFAULT NULL,
  `VEHICLE_INFO_LEVEL` decimal(5,0) DEFAULT NULL,
  `VIDEO_URL` text,
  `CNT` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS vehicle_appearance_prediction;
CREATE TABLE `vehicle_appearance_prediction` (
  `id` int(11) NOT NULL,
  `predict_camera_no` int(11) DEFAULT NULL,
  `predict_camera_name` varchar(255) DEFAULT NULL,
  `predict_date` date DEFAULT NULL,
  `predict_start_time` time DEFAULT NULL,
  `predict_end_time` time DEFAULT NULL,
  `vehicle_plate_no` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
