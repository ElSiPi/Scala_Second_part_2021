

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object MapExercise extends App {


  def genMap(testSize: Int = 5): Map[String, Int] = {
    (0 until testSize).map(n => n.toString -> Random.nextInt(testSize)).toMap
  }

  val testMap = genMap()

  //TODO write Map reversal function for key,value to value,key
  def reverseMap(map: Map[String, Int]): Map[Int, String] = {
    val newMap = scala.collection.mutable.Map[Int, String]() //this is overhead

    for ((key, value) <- map) {
      newMap(value) = key
    }
    val reversedMap: Map[Int, String] = newMap.toMap
    reversedMap
  }

  def reverseMap2(map: Map[String, Int]): Map[Int, String] = {
    val newMap = for ((k, v) <- map) yield (v, k)
    newMap
  }

  def reverseMap3(map: Map[String, Int]): Map[Int, String] = {
    val reversedMap = map.map(_.swap)
    reversedMap
  }
}
