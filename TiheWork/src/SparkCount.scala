import org.apache.spark.{SparkConf, SparkContext}
import java.sql.{Connection, DriverManager, PreparedStatement}

import org.apache.spark.rdd.RDD
/**
  * Created by miracle on 2016/6/14.
  */
object SparkCount {
  

  def importMySQL(iterator: Iterator[String]): Unit = {



    //初始化变量
    var conn: Connection = null
    var ps: PreparedStatement = null
    val sql = "insert into car_overview(cross_id,car_cross_cnt,cross_time) values (?,?,?)"
    val conn_str = "jdbc:mysql://127.0.0.1:3306/transportation?user=root&password=root&useSSL=false"
    try {
      conn = DriverManager.getConnection(conn_str);

      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        var input = data.split(",")
        ps = conn.prepareStatement(sql)
        ps.setString(1,input(0))
        ps.setInt(2,input(2).toInt)
        ps.setString(3,input(1))

        ps.executeUpdate()
        println("dddd")
      })
      val s2 = System.currentTimeMillis();
      println("update data  consume time:" + (s2 - s1) + "ms")
    } catch {
      case e: Exception => println(e)
    } finally {
      if (null != ps) {
        ps.close()
      }
      if (null != conn) {
        conn.close()
      }
    }
  }


  def main(args: Array[String])
  {


    val conf = new SparkConf().setAppName("Vehicle").setMaster("local")

    //val conf = new SparkConf().setAppName("Vehicle").setMaster("local[*]")
    val sc=new SparkContext(conf)
    val data = sc.textFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Car_Overview\\part-00000").map(line =>{
      var tmp = line.replace("(","")
      var value = tmp.replace(")","")
      value
    })

    //val data = sc.parallelize(List(("www", 10), ("iteblog", 20), ("com", 30)))
    data.foreachPartition(importMySQL)
    sc.stop();


  }

  }
