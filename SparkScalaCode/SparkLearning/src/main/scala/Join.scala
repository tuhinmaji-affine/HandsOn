import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col}
object Join extends App{
val spark=SparkSession.builder().appName("Spark SQL").master("local[*]").getOrCreate()
  val empDF=spark.read.option("header","true").csv("D:\\Expedia\\SparkScalaCode\\SparkLearning\\input\\Emp.csv")
  val deptDF=spark.read.option("header","true").csv("D:\\Expedia\\SparkScalaCode\\SparkLearning\\input\\Dept.csv")
  empDF.show(1)
  deptDF.show(1)
  //Inner Join
  val joinExpression=empDF.col("DeptId")===deptDF.col("DeptId")
  val joinType="inner"
  empDF.join(deptDF,joinExpression,joinType).show()
//Outer Join
  println("Outer join result")
  empDF.join(deptDF,joinExpression,"outer").show()
  //left outer join
  println("result of left outer join")
  empDF.join(deptDF,joinExpression,"left_outer").show()
  spark.sql("CREATE DATABASE sampledb;")
  spark.sql("USE DATABASE sampledb;")
  spark.stop()
}
