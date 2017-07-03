/**
  * Created by hp on 2017/6/27.
  */

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}


class Data_Preprocessing(@transient sc:SparkContext ) extends Serializable {

  /**
    *funName To_Car_Overview_Cross
    * Description 预测时间范围内各卡口可能经过的车辆
    * @param vehicleRDD 过车数据
    * @param preDateTime 预测时间
    * @return RDD[(String)] 每辆车的预测经过卡口
    */
  def To_Car_Overview_Cross(vehicleRDD:RDD[Array[String]],preDateTime:String) :RDD[String]= {
    var tu = new Time_Utils
    var oldDateTime = tu.changeStringTimeMonth(preDateTime,-1)
    val tmpRDD1 = vehicleRDD.filter(x =>{
      var dateTime = x(3).split(" ")
      tu.equality2Date(dateTime(0),oldDateTime)
    }).map(i=>{
            val dateTime = i(3).split(" ")
            val dayTime = dateTime(0)
            val tmp = dateTime(1).split(":")
            val hourTime = tmp(0)

            var value = i(4)+","+i(1)+","+preDateTime+","+hourTime+","+i(2)
            value
    })

    val tmpRDD2 = vehicleRDD.filter(y =>{
      var dateTime = y(3).split(" ")
      tu.compare2Week(dateTime(0),preDateTime,-1)
    }).map(j=> {
      val dateTime = j(3).split(" ")
      val dayTime = dateTime(0)
      val tmp = dateTime(1).split(":")
      val hourTime = tmp(0)

      var value = j(4) + "," + j(1) + "," +preDateTime+","+ hourTime + "," + j(2)
      value
    })
    var dataRDD1 = tmpRDD1.union(tmpRDD2)
    dataRDD1
  }

  /**
    *funName To_Car_Overview
    * Desciption 统计重点关注车辆经过的卡口
    * @param focusRDD 重点关注车辆过车数据
    * @return RDD[(String, Int)] 重点车辆经过卡口的次数统计
    */
  def To_Car_Overview(focusRDD:RDD[String]) :RDD[(String, Int)]= {
    val dataRDD2 = focusRDD.map(line => {
      val x = line.split(",")
      var rowkey: String = null
      rowkey = x(0)+","+x(2)
      (rowkey, 1)
    }).reduceByKey((x, y) => x + y)
    return dataRDD2
  }

  /**
    * funName To_Car_Cross_Hour_Cnt
    * Description 按小时统计过车次数
    * @param vehicleRDD 过车数据
    * @return RDD[(String, Int)]
    */
  def To_Car_Cross_Hour_Cnt(vehicleRDD:RDD[Array[String]]) :RDD[(String, Int)]= {
    val dataRDD3 = vehicleRDD.map(i => {
      val dateTime = i(3).split(" ")
      val dayTime = dateTime(0)
      val tmp = dateTime(1).split(":")
      val hourTime = tmp(0)
      var rowkey: String = null
      rowkey = i(1) + "," +i(4)+","+dayTime+","+hourTime
      (rowkey, 1)
    }).reduceByKey((x, y) => x + y).sortBy(g=>g._1.split(",")(2))
    return dataRDD3
  }

  /**
    * funName To_Car_Cross_Day_Cnt
    * Description 按天统计过车次数
    * @param vehicleRDD 过车数据
    * @return RDD[(String, Int)]
    */
  def To_Car_Cross_Day_Cnt(vehicleRDD:RDD[Array[String]]) :RDD[(String, Int)]= {
    val dataRDD4 = vehicleRDD.map(i => {
      val dateTime = i(3).split(" ")
      val dayTime = dateTime(0)
      val tmp = dateTime(1).split(":")
      var tu = new Time_Utils
      val week = tu.dayOfWeek(dayTime)
      val hourTime = tmp(0)
      var rowkey: String = null
      rowkey = i(1) + "," +i(4)+","+dayTime+","+week
      (rowkey, 1)
    }).reduceByKey((x, y) => x + y).sortBy(g=>g._1.split(",")(2))
    return dataRDD4
  }

  /**
    * funName To_Car_Cross_Year_Cnt
    * Description 按月统计过车次数
    * @param vehicleRDD 过车数据
    * @return RDD[(String, Int)]
    */
  def To_Car_Cross_Year_Cnt(vehicleRDD:RDD[Array[String]]) :RDD[(String, Int)]= {
    val dataRDD5 = vehicleRDD.map(i => {
      val dateTime = i(3).split(" ")
      val tmp = dateTime(0).split("/")
      val yearTime = tmp(0)
      val mouthTime = tmp(1)
      var rowkey: String = null
      rowkey = i(1) + "," +i(4)+","+yearTime+","+mouthTime
      (rowkey, 1)
    }).reduceByKey((x, y) => x + y).sortBy(g=>g._2,ascending = false)
    return dataRDD5
  }
}
