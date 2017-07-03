import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by hp on 2017/6/29.
  */
object Test {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("test")
    val sc = new SparkContext(conf)

    val vehicleRDD = sc.textFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\Vehicle_DATA.csv").filter(line => !line.contains("号牌种类")).map(x=>{
      var result = x.split(",")
      var rowkey = result(1)
      var value = result(0)+","+result(2)+","+result(3)
      (rowkey,value)
    })

    //黑名单车辆过滤
    val blackList = sc.textFile("D:\\WorkSpace\\intelij_work\\TiHeWork\\focus_on_vehicle.csv").map((_,1))
    val rs =  vehicleRDD.join(blackList)
    for (i <- rs){
      print(i)
    }

    //      val focusRDD = vehicleRDD.filter(x => {
    //         for (i <- blackList){
    //            if (i == x(1))
    //               true
    //          }
    //              false
    //        })
  }
}
