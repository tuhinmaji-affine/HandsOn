import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.count
//import org.apache.spark.sql.functions.{count}
object Aggregation2 extends App {
val spark=SparkSession.builder().appName("Spark SQL").master("local[*]").getOrCreate()
  val df=spark.read.option("header","true").csv("D:\\Sample Data\\car_data.csv")
  df.show(3)
df.groupBy("fuel_type").count().show()
//another way
  df.groupBy("fuel_type").agg(count("aspiration").alias("cnt")).show()
  spark.stop()
}
