import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col


// For implicit conversions like converting RDDs to DataFrames

object DataFrame2 extends App {
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .master("local[*]")
    .getOrCreate()

val df=spark.read.option("header","true").csv("D:\\Expedia\\SparkScalaCode\\SparkLearning\\input\\AAPL.csv")
  df.show(3)
  df.printSchema()
  //first row
  print(df.first())
  println("Done")
  //last row
  //create temp view
  df.createOrReplaceTempView("sampleTbl")
  spark.sql("SELECT * FROM sampleTbl LIMIT 10;").show()
  //removing columns
  val df2=df.drop("Volume")
  println("--------After removing columns-------")
  df2.show(3)
  val df3=df.drop("High","Low")
  println("-------After removing multiple columns----------")
  df3.show(3)
  df.filter(col("Open")>0.12).show(2)
  println("----------Multiple filter-----------")
df.where(col("Open")>0.12).where(col("High")>0.12).show(3)

  //distinct count
  println("Distinct count:---------------")
  println(df.select("Open").distinct().count())

}
