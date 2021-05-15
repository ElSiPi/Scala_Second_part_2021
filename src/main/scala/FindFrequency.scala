import javafx.stage.StageStyle

object FindFrequency extends App{
  val srcPath = "./src/resources/numbers.txt"
  val uniquePath = "./src/resources/uniques.txt"
  val frequencies = "./src/resources/frequencies.txt"
  println(s"Find unique numbers in $srcPath")
  //TODO find uniques -> save to $uniques
  //TODO save number usage frequencies in the following format
  //0 2
  //1 3
  //4 1
  //9 6 times etc

  //HINTS we can use Map
  //Also groupBy might help

  val numbers = Utilities.getLinesFromFile(srcPath)
  val uniqueNumbers = numbers.toSet.toSeq
  val numbNumb = numbers.foreach(entry => entry.toInt)

  Utilities.saveLines(uniqueNumbers, uniquePath)



}
