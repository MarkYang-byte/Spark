package com.wenbinyang.spark;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
/**
 * @author Wenbin.Yang
 * @create 2019-11-18 22:50
 */
public class TestSpark {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .master("local")
                .getOrCreate();
        Dataset<Row> jdbcDF = spark.read()
                .format("jdbc")
                .option("url", "jdbc:mysql://localhost:3306/test")
                .option("dbtable", "test.table01")
                .option("user", "root")
                .option("password", "123456")
                .load();
        jdbcDF.show();
    }
}
