package com.experiments.mu.extract

import org.apache.spark._
import org.apache.spark.sql.{SparkSession}

object extract {
  def main(args: Array[String]) = {
    println("Hi there!")
    val conf = new SparkConf()

    val spark =
      SparkSession.builder().master("local[*]").appName("mu-extract").getOrCreate()

    import spark.implicits._

    val sales = spark.read.option("header", "true").csv("src/main/resources/SalesJan2009.csv")

    val salesWithNumericPrice = sales.map(r => (r.getString(0), r.getString(1), r.getString(2).toLong))
      .toDF("Transaction_date", "Product", "Price")

    salesWithNumericPrice.groupBy("Product").avg("Price").show()
  }
}
