/**
  * Created by hp on 2017/6/29.
  */

import java.sql.{Connection, DriverManager, PreparedStatement}
import org.apache.spark.SparkContext

class MySQL_Handle(@transient sc:SparkContext)  extends Serializable{
//连接数据库的字符串
  var conn: Connection = null
  val conn_str = "jdbc:mysql://127.0.0.1:3306/transportation?user=root&password=root&useSSL=false"

  /**
    * funName carOverviewInsert
    * Description 插入数据库中car_overview
    * @param iterator
    */
  def carOverviewInsert(iterator: Iterator[(String,Int)]): Unit = {
    //初始化变量
    var ps: PreparedStatement = null
    val sql = "insert into car_overview(cross_id,car_cross_cnt,cross_time) values (?,?,?)"
    try {
      conn = DriverManager.getConnection(conn_str);
      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        var input = data._1.split(",")
        ps = conn.prepareStatement(sql)
        ps.setString(1,input(0))
        ps.setInt(2,data._2)
        ps.setString(3,input(1))

        ps.executeUpdate()
      })
      val s2 = System.currentTimeMillis();
      println("update data  consume time:" + (s2 - s1) + "ms")
    } catch {
      case e: Exception => println(e)
    } finally {
      if (null != ps) {
        print("ok!")
        ps.close()
      }
      if (null != conn) {
        conn.close()
      }
    }
  }

  /**
    * funName carOverviewCrossInsert
    * Description 插入数据库中car_overview_cross
    * @param iterator
    */
  def carOverviewCrossInsert(iterator: Iterator[String]): Unit = {
    //初始化变量
    var ps: PreparedStatement = null
    val sql = "insert into car_overview_cross(cross_id,plate_no,cross_time,hour_num,alert_type) values (?,?,?,?,?)"
    try {
      conn = DriverManager.getConnection(conn_str);
      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        ps = conn.prepareStatement(sql)

        var input = data.split(",")

        ps.setString(1,input(0))
        ps.setString(2,input(1))
        ps.setString(3,input(2))
        ps.setString(4,input(3))
        ps.setString(5,input(4))

        ps.executeUpdate()
      })
      val s2 = System.currentTimeMillis();
      println("update data  consume time:" + (s2 - s1) + "ms")
    } catch {
      case e: Exception => println(e)
    } finally {
      if (null != ps) {
        print("ok!")
        ps.close()
      }
      if (null != conn) {
        conn.close()
      }
    }
  }

  /**
    * funName carCrossHourCntInsert
    * Description 插入数据库中car_cross_hour_cnt
    * @param iterator
    */
  def carCrossHourCntInsert(iterator: Iterator[(String,Int)]): Unit = {
    //初始化变量
    var ps: PreparedStatement = null
    val sql = "insert into car_cross_hour_cnt(cross_id,plate_no,cross_time,hour_num,cross_cnt) values (?,?,?,?,?)"
    try {
      conn = DriverManager.getConnection(conn_str);
      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        ps = conn.prepareStatement(sql)

        var input = data._1.split(",")

        ps.setString(1,input(1))
        ps.setString(2,input(0))
        ps.setString(3,input(2))
        ps.setString(4,input(3))
        ps.setInt(5,data._2)

        ps.executeUpdate()

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

  /**
    * funName carCrossDayCntInsert
    * Description 插入数据库中car_cross_day_cnt
    * @param iterator
    */
  def carCrossDayCntInsert(iterator: Iterator[(String,Int)]): Unit = {
    //初始化变量
    var ps: PreparedStatement = null
    val sql = "insert into car_cross_day_cnt(cross_id,plate_no,cross_time,week_num,cross_cnt) values (?,?,?,?,?)"
    try {
      conn = DriverManager.getConnection(conn_str);
      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        ps = conn.prepareStatement(sql)

        var input = data._1.split(",")

        ps.setString(1,input(1))
        ps.setString(2,input(0))
        ps.setString(3,input(2))
        ps.setString(4,input(3))
        ps.setInt(5,data._2)

        ps.executeUpdate()
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

  /**
    * funName carCrossYearCntInsert
    * Description 插入数据库中car_cross_year_cnt
    * @param iterator
    */
  def carCrossYearCntInsert(iterator: Iterator[(String,Int)]): Unit = {
    //初始化变量
    var ps: PreparedStatement = null
    val sql = "insert into car_cross_year_cnt(cross_id,plate_no,year_num,month_num,cross_cnt) values (?,?,?,?,?)"
    try {
      conn = DriverManager.getConnection(conn_str);
      val s1 = System.currentTimeMillis();
      iterator.foreach(data => {
        ps = conn.prepareStatement(sql)

        var input = data._1.split(",")

        ps.setString(1,input(1))
        ps.setString(2,input(0))
        ps.setString(3,input(2))
        ps.setString(4,input(3))
        ps.setInt(5,data._2)

        ps.executeUpdate()
      })
      val s2 = System.currentTimeMillis();
      println("update data  consume time:" + (s2 - s1) + "ms")
    } catch {
      case e: Exception => println(e)
    } finally {
      if (null != ps) {
        print("ok!")
        ps.close()
      }
      if (null != conn) {
        conn.close()
      }
    }
  }
}
