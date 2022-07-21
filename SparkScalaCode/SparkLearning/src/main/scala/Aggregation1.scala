import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{count,countDistinct,first,last,min,max,sum,avg}
object Aggregation1 extends App{
val spark=SparkSession.builder().appName("Spark SQL").master("local[*]").getOrCreate()
  val df=spark.read.option("header","true").csv("D:\\Expedia\\SparkScalaCode\\SparkLearning\\input\\AAPL.csv")
  //count of rows

  val cntRows=df.count()
  println("The count of rows in DataFrame:"+cntRows)
  //Another way
  val cntOpen=df.select(count("Open")).collect()
  println("Count of Open Column:"+cntOpen)
  //Distinct count
  println("Distinct count")
  df.select(countDistinct("Open")).show()
  //first last
  df.select(first("Open"),last("Open")).show()
//min max
  df.select(min("Open"),max("Open")).show()
  //sum
  df.select(sum("Open")).show()
  //average
  df.select(avg("Open")).show()
  spark.stop()

}
