import org.apache.spark
import org.apache.spark.sql.SparkSession
object DataFrame1 extends App {
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .master("local[*]")
    .getOrCreate()
  val df=spark.range(50).toDF("number");
  df.select("number").show(10);
}
