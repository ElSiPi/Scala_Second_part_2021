import scala.util.Random

object Sequences extends App{

  val testSize = 1000
  val numTests = 100
  val arrayNumbers = (1 to testSize).map(n => Random.nextInt(testSize)).toArray
  val seqNumbers = (1 to testSize).map(n => Random.nextInt(testSize)).toArray.toSeq
  val indexedNumbers = (1 to testSize).map(n => Random.nextInt(testSize))
  val listNumbers = (1 to testSize).map(n => Random.nextInt(testSize)).toList
  val vectorNumbers = (1 to testSize).map(n => Random.nextInt(testSize)).toVector

  def testSeq(data:Seq[Int]): Long = {
    val middle = testSize/2
    val t0 = System.nanoTime()
    //val sum = data.sum // one loop
    //val sum = data.head + data.last //expect list to win here but no
    val sum = data.head + data(middle) + data.last
    val t1 = System.nanoTime()
    val delta = t1-t0
    //println(s"Test Sequence executed in ${delta/1000} microseconds")
    delta
  }

  val arrayRes = (1 to numTests).map(n => testSeq(arrayNumbers)).sum // and mappin is loop
  val seqRes = (1 to numTests).map(n => testSeq(seqNumbers)).sum
  val indexedRes = (1 to numTests).map(n => testSeq(indexedNumbers)).sum
  val listRes = (1 to numTests).map(n => testSeq(listNumbers)).sum
  val vectorRes = (1 to numTests).map(n => testSeq(vectorNumbers)).sum

  println(s"Array results are    ${arrayRes/numTests}")
  println(s"Sequence results are ${seqRes/numTests}")
  println(s"Indexed results are  ${indexedRes/numTests}")
  println(s"List results are     ${listRes/numTests}")
  println(s"Vector results are   ${vectorRes/numTests}")



}
