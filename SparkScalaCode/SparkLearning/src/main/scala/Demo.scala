
import org.apache.spark.sql.SparkSession

object Demo {
  def main(args: Array[String]) {
    val logFile = "D:\\Expedia\\SparkScalaCode\\SparkLearning\\input\\sample.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").master("local[*]").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
