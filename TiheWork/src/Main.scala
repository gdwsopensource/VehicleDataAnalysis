/**
  * Created by hp on 2017/6/27.
  */

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Main {
  /**
    * Description 数据预处理
    *
    */
  def main(args:Array[String]): Unit = {

//    System.setProperty("hadoop.home.dir", "D:\\hadoop-2.6.4\\hadoop-2.6.4")
    //    非本地运行配置
//    val conf = new SparkConf().setAppName("TiHeWork")

    val conf = new SparkConf().setMaster("local").setAppName("TiHeWork")
    val sc = new SparkContext(conf)

//    vehicleRDD存储过车数据
    val vehicleRDD = sc.textFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\vehicle_cross.csv").filter(line => !line.contains("号牌种类")).map(_.split(','))
//   输入需要预测的时间
    val preDateTime = "2017/7/9"



//   blackList存入 黑名单车辆
   val blackList = sc.textFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\focus_on_vehicle.csv").collect()
//    for (i <- blackList)
//      print(i+"......")

//    数据预处理
    val dp = new Data_Preprocessing(sc)
//    dataRDD1存入 车辆预测数据
    val dataRDD1 = dp.To_Car_Overview_Cross(vehicleRDD,preDateTime)

//    focusRDD存入 重点关注车辆
    val focusRDD = dataRDD1.filter(line => {
    var x = line.split(",")
      blackList.contains(x(1))
   })
//        focusRDD.foreach(line=>{
//         var x = line.split(",")
//          print(x(1)+"....")
//        })

//    dataRDD2存入 统计重点关注卡口
    var dataRDD2 = dp.To_Car_Overview(focusRDD)
//    dataRDD3存入 根据车牌+卡口+时间（小时）统计
    val dataRDD3 = dp.To_Car_Cross_Hour_Cnt(vehicleRDD)
//    dataRDD4存入 根据车牌+卡口+时间（天）统计
    val dataRDD4 = dp.To_Car_Cross_Day_Cnt(vehicleRDD)
//    dataRDD5存入 根据车牌+卡口+时间（月）统计
    val dataRDD5 = dp.To_Car_Cross_Year_Cnt(vehicleRDD)

//    结果存入MySQL数据库
    val msql = new MySQL_Handle(sc)
    dataRDD1.foreachPartition(msql.carOverviewCrossInsert)
    dataRDD2.foreachPartition(msql.carOverviewInsert)
    dataRDD3.foreachPartition(msql.carCrossHourCntInsert)
    dataRDD4.foreachPartition(msql.carCrossDayCntInsert)
    dataRDD5.foreachPartition(msql.carCrossYearCntInsert)

//结果存入.csv文件中
//    dataRDD1.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Overview_Cross")
//    focusRDD.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\focus")
//    dataRDD2.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Overview")
////    dataRDD3.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Cross_Hour_Cnt")
////    dataRDD4.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Cross_Day_Cnt")
////    dataRDD5.saveAsTextFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Cross_Year_Cnt")
  }
}
