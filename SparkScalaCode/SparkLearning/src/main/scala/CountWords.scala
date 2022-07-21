import org.apache.spark.sql.SparkSession
object CountWords extends  App {
val spark=SparkSession.builder().appName("SQL work").master("local[*]").getOrCreate()
  //val df=spark.read.textFile("input/abc.txt")

}
