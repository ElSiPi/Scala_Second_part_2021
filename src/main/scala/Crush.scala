import java.io.File
import scala.io.Source

object Crush extends App {

  val folderName = "./src/resources"

  //method for getting file paths
  def getFileNames(folder:String, prefix:String="", suffix:String =".txt"): Array[String] = {
    val d = new File(folder)
    if (d.exists && d.isDirectory) {
      d.listFiles
        .filter(_.isFile)
        .map(_.toString)
        .filter(_.split("\\\\").last.startsWith(prefix)) //windows specific escaping for file paths \\
        .filter(_.endsWith(suffix))
    } else {
      Array[String]()
    }
  }

  val filePaths = getFileNames(folderName, prefix="cru", suffix = "xt")

 //methods that will be used to solve the problem
 //method for saving the lines form file
  def getLinesFromFile(srcPath: String, encoding:String="UTF8"): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath, enc=encoding)
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close
    lines
  }

  //take first line and get the amount of zeros in the initial array
  def makeSequenceOfZeros(inputArr:Array[String]):Array[Int] ={
    val firstLine = inputArr(0).split(" ")
    val zeros = firstLine(0).toInt
    val seqOfZeros = (1 to zeros).map(_ => 0)
    seqOfZeros.toArray
  }

  //get array with the values, that will be used
  def getLinesFromSecondToEnd(inputArr:Array[String]): Array[String] ={
    inputArr.slice(1, inputArr.length)
  }

  //for each string in the array split numbers by space. take them and parse to ints. adjust index numbering
  //add the values to corresponding zeros in the initial array
  def performTasks(workSeq:Array[Int], taskSeq:Array[String]): Array[Int] = {
    for(entry <- taskSeq) {
      val oneLineSplit = entry.split(" ")
      val index0 = oneLineSplit(0).toInt - 1
      val index1 = oneLineSplit(1).toInt - 1
      val index2 = oneLineSplit(2).toInt

      workSeq(index0) += index2
      workSeq(index1) += index2
    }
   workSeq
  }

  //method combines all previous methods and solves the problem
  def getAnswer(filePath:String):Int = {
    val lines = getLinesFromFile(filePath)
    val initSeq = makeSequenceOfZeros(lines)
    val seqOfTasks = getLinesFromSecondToEnd(lines)
    val results = performTasks(initSeq, seqOfTasks)
    results.max
  }

  //print out the solution
  def printAnswer(answer:Int): Unit = {
    println(answer)
  }

  //print solution for each crush file
  filePaths.foreach(filePath => println(s"Answer for $filePath is ${getAnswer(filePath)}"))

}
