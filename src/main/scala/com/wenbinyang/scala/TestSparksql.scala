package com.wenbinyang.scala

/**
 * @ Wenbin.Yang
 * @ 2019-11-19 9:42
 */
object TestSparksql {
  def main(args: Array[String]): Unit = {

    import org.apache.spark.sql.SparkSession

    val spark = SparkSession
      .builder()
      .appName("Scala Spark SQL basic example")
      .master("local")
      .getOrCreate()

    val jdbcDF = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/test")
      .option("dbtable", "test.table01")
      .option("user", "root")
      .option("password", "123456")
      .load
    jdbcDF.show()
  }
}
