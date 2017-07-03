/**
  * Created by hp on 2017/6/29.
  */
import java.text.{DateFormat, SimpleDateFormat}
import java.util.{Calendar, Date}

import org.joda.time.DateTime

import scala.collection.mutable.ArrayBuffer

class Time_Utils extends Serializable{


  final val ONE_HOUR_MILLISECONDS = 60 * 60 * 1000

  final val SECOND_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss"

  final val DAY_DATE_FORMAT_ONE = "yyyy/MM/dd"

  final val DAY_DATE_FORMAT_TWO = "yyyyMMdd"

  /**
    * funName convertDateStr2TimeStamp
    * Description 时间字符串=>时间戳,"2017-6-30"=>"1498752000000"
    * @param dateStr 时间字符
    * @param pattern 时间字符的格式
    * @return Long型，时间戳
    */
  def convertDateStr2TimeStamp(dateStr: String, pattern: String): Long = {
    new SimpleDateFormat(pattern).parse(dateStr).getTime
  }

  /**
    * funName convertDateStr2Date
    * Description 时间字符串=>日期
    * @param dateStr 时间字符串
    * @param pattern 时间字符的格式
    * @return DateTime型，日期
    */
  def convertDateStr2Date(dateStr: String, pattern: String): DateTime = {
    new DateTime(new SimpleDateFormat(pattern).parse(dateStr))
  }

  /**
    * funName convertTimeStamp2Date
    *  Description 时间戳=>日期
    * @param timestamp 时间戳
    * @return DateTime型，日期
    */
  def convertTimeStamp2Date(timestamp: Long): DateTime = {
    new DateTime(timestamp)
  }

  /**
    * funName convertTimeStamp2DateStr
    * Description 时间戳=>字符串
    * @param timestamp 时间戳
    * @param pattern 转化的时间字符的格式
    * @return String型，时间字符串
    */
  def convertTimeStamp2DateStr(timestamp: Long, pattern: String): String = {
    new DateTime(timestamp).toString(pattern)
  }

  /**
    * funName convertTimeStamp2Hour
    * Description 时间戳=>取小时数
    * @param timestamp 时间戳
    * @return Long型，小时
    */
  def convertTimeStamp2Hour(timestamp: Long): Long = {
    new DateTime(timestamp).hourOfDay().getAsString().toLong
  }


  /**
    * funName convertTimeStamp2Minute
    * Description 时间戳=>取分钟数
    * @param timestamp 时间戳
    * @return Long型，分钟
    */
  def convertTimeStamp2Minute(timestamp: Long): Long = {
    new DateTime(timestamp).minuteOfHour().getAsString().toLong
  }


  /**
    * funName convertTimeStamp2Sec
    * Description 时间戳=>取秒数
    * @param timestamp 时间戳
    * @return Long型，秒
    */
  def convertTimeStamp2Sec(timestamp: Long): Long = {
    new DateTime(timestamp).secondOfMinute().getAsString.toLong
  }

//给小时前面加0，比如"9"=>"09"
  /**
    * funName addZero
    * Description 给小时前面加0，比如"9"=>"09"
    * @param hourOrMin 小时字符
    * @return String
    */
  def addZero(hourOrMin: String): String = {
    if (hourOrMin.toInt <= 9)
      "0" + hourOrMin
    else
      hourOrMin

  }

  /**
    * funName delZero
    * Description 去掉小时前面的"0"
    * @param hourOrMin
    * @return String
    */
  def delZero(hourOrMin: String): String = {
    var res = hourOrMin
    if (!hourOrMin.equals("0") && hourOrMin.startsWith("0"))
      res = res.replaceAll("^0","")
    res
  }

  /**
    * funName  dateStrPatternOne2Two
    * Description 转换时间字符的格式，"yyyy-MM-dd"=>"yyyyMMdd"
    * @param time 时间字符
    * @return String
    */
  def dateStrPatternOne2Two(time: String): String = {
    this.convertTimeStamp2DateStr(this.convertDateStr2TimeStamp(time, this
      .DAY_DATE_FORMAT_ONE), this.DAY_DATE_FORMAT_TWO)
  }


  /**
    * funName dayOfWeek
    * Description 得到时间字符的星期几
    * @param dateStr 时间字符
    * @return Int型，星期几
    */
  def dayOfWeek(dateStr: String): Int = {
    val sdf = new SimpleDateFormat("yyyy/MM/dd")
    val date = sdf.parse(dateStr)

    //    val sdf2 = new SimpleDateFormat("EEEE")
    //    sdf2.format(date)

    val cal = Calendar.getInstance();
    cal.setTime(date);
    var w = cal.get(Calendar.DAY_OF_WEEK) - 1;

    //星期天 默认为0
    if (w <= 0)
      w = 7
    w
  }

  /**
    * funName isRestday
    * Description 判断是否是周末
    * @param date 时间字符
    * @return Boolean型
    */
  def isRestday(date: String): Boolean = {
    val dayNumOfWeek = dayOfWeek(date)
    dayNumOfWeek == 6 || dayNumOfWeek == 7
  }

  /**
    * funName changeStringTimeYear
    * Description 按年增减时间，如：（2017/1/2,-1）=> (2016/1/2)
    * @param timeString 时间字符
    * @param increment 增减量
    * @return String型，时间字符串
    */
  def changeStringTimeYear(timeString:String , increment:Int): String= {
    val fmt:DateFormat =new SimpleDateFormat("yyyy/MM/dd")
    val date = fmt.parse(timeString)
    val calendar = Calendar.getInstance();  //得到日历
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.YEAR, increment)
    val changeDay = calendar.getTime
    val dateString = fmt.format(changeDay)
    dateString
  }

  /**
    * funName changeStringTimeMonth
    * Description 按月增减时间，如：（2017/3/2,-1）=> (2017/2/2)
    * @param timeString 时间字符
    * @param increment 增减量
    * @return String型，时间字符串
    */
  def changeStringTimeMonth(timeString:String , increment:Int): String= {
    val fmt:DateFormat =new SimpleDateFormat("yyyy/MM/dd")
    val date = fmt.parse(timeString)
    val calendar = Calendar.getInstance();  //得到日历
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.MONTH, increment)
    val changeDay = calendar.getTime
    val dateString = fmt.format(changeDay)
    dateString
  }

  /**
    * funName changeStringTimeDay
    * Description 按天增减时间，如：（2017/3/2,-1）=> (2017/3/1)
    * @param timeString 时间字符
    * @param increment 增减量
    * @return String型，时间字符串
    */
  def changeStringTimeDay(timeString:String , increment:Int): String= {
    val fmt:DateFormat =new SimpleDateFormat("yyyy/MM/dd")
    val date = fmt.parse(timeString)
    val calendar = Calendar.getInstance();  //得到日历
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.DATE, increment)
    val changeDay = calendar.getTime
    val dateString = fmt.format(changeDay)
    dateString
  }

  /**
    * funName changeStringTimeMinute
    * Description  按分钟加减时间
    * @param date 时间字符
    * @param increment 增减量
    * @return String型，时间字符串
    */
  def changeStringTimeMinute(date:Date,increment:Int): Date= {
    val calendar = Calendar.getInstance();  //得到日历
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.MINUTE, increment)
    val changeDay = calendar.getTime
    changeDay
  }

  /**
    * funName changeStringTimeSecond
    * Description  按秒加减时间
    * @param timeString 时间字符
    * @param increment 增减量
    * @return String型，时间字符串
    */
  def changeStringTimeSecond(timeString:String , increment:Int): String= {
    val fmt:DateFormat =new SimpleDateFormat("yyyyMMddHHmmss")
    val date = fmt.parse(timeString)
    val calendar = Calendar.getInstance();  //得到日历
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.SECOND, increment)
    val changeDay = calendar.getTime
    val dateString = fmt.format(changeDay)
    dateString
  }

  /**
    * funName equality2Date
    * Descritption 比较两个时间字符是否相等
    * @param time1
    * @param time2
    * @return Boolean型
    */
  def equality2Date (time1:String ,time2:String):Boolean = {
    if(this.convertDateStr2TimeStamp(time1,this.DAY_DATE_FORMAT_ONE) == this.convertDateStr2TimeStamp(time2,this.DAY_DATE_FORMAT_ONE))
       true
    else
       false
  }

  /**
    * funName compare2Week
    * Description time1是否在time2和time2+increment之间，并且time1的星期与time2相同
    * @param time1
    * @param time2
    * @param increment
    * @return Boolean型
    */
  def compare2Week (time1:String ,time2:String,increment:Int):Boolean = {
    var time3 = this.changeStringTimeMonth(time2,increment)
    //查询时间
    var timeStamp1 = this.convertDateStr2TimeStamp(time1,this.DAY_DATE_FORMAT_ONE)
    //结束时间
    var timeStamp2 = this.convertDateStr2TimeStamp(time2,this.DAY_DATE_FORMAT_ONE)
    //开始时间
    var timeStamp3 = this.convertDateStr2TimeStamp(time3,this.DAY_DATE_FORMAT_ONE)

    if(timeStamp1 > timeStamp3 && timeStamp1 < timeStamp2){
      //结束时间的周几
      var week2 = this.dayOfWeek(time2)
      //查询时间的周几
      var week1 = this.dayOfWeek(time1)
      if(week2 == week1)
        true
      else
        false
    }else
      false
  }
}
