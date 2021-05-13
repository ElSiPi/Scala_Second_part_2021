import scala.io.Source

object SparseArrays extends App{
  // https://www.hackerrank.com/challenges/sparse-arrays/problem
  //TODO read and parse ../resources/arr1.txt
  //TODO read and parse ../resources/arr2.txt
  //return (println) the results

 //  val source1 = "src/resources/arr1.txt"
//  val source2 = "src/resources/arr2.txt"
//  val lines = getLinesFromFile(source1)

  def getFilePath(beg:Int, end:Int, prefix:String = "src/resources/arr", suffix:String = ".txt"):Array[String] ={
    (beg to end).map(num => s"$prefix$num$suffix").toArray
  }
 val folderName = "./src/resources"
  //val filePaths = getFilePath(1, 3)

  def getAnswers(lines:Array[String]) : Array[Int] ={
  val numbOfString = lines(0).toInt
  val stringEnd = numbOfString+1
  val strings = lines.slice(1, stringEnd)
  val queries = lines.slice(stringEnd+1, lines.length)

    //for debugging
//  println("*"*20)
//  strings.foreach(println)
//  println("*"*20)
//  queries.foreach(println)
//  println("*"*20)

  val answers = queries.map(qry => strings.count(entry => entry == qry))
  //answers.foreach(println)
  answers
  }

  def getAnswersFromFileName(filePath:String):Array[Int] = {
    val lines = Utilities.getLinesFromFile(filePath)
    getAnswers(lines)
  }

  def printAnswers(answers:Array[Int]):Unit = {
    answers.foreach(println) //adjust formatting without braking code
    println("*"*20)
  }

//  printAnswers(getAnswersFromFileName(source1))
//  println()
//  printAnswers(getAnswersFromFileName(source2))

  //val filePaths = Utilities.getFileNames(folderName)
  val filePaths = Utilities.getFileNames(folderName, prefix="arr", suffix=".txt")
  filePaths.foreach(println)
  filePaths.foreach(filePath => printAnswers(getAnswersFromFileName(filePath)))



}
