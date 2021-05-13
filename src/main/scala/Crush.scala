object Crush extends App {

  //TODO Solve the following problem
  //https://www.hackerrank.com/challenges/crush/problem
  //TODO read and parse ../resources/crush1.txt
  //TODO read and parse ../resources/crush2.txt
  //you need to perform 3 operations
  //and find the maximum in the new array

  //think how well this would work on large values of operations like
  //1000 1000

  val source = "./src/resources/crush1.txt"
  val task = Utilities.getLinesFromFile(source)

  val numbOfZeros = Character.getNumericValue(task(0).charAt(0))
  println(numbOfZeros)

  val testIndexedSeq = (1 to numbOfZeros).map(entry => 0)
  testIndexedSeq.foreach(println)

  val operationString = task(1)
  val indexToChange1 = Character.getNumericValue(operationString.charAt(0))
  val indexToChange2 = Character.getNumericValue(operationString.charAt(2))
  val value =  operationString.charAt(4).to(operationString.charAt(operationString.length))
  //val valueAsInt =

  println(indexToChange1, indexToChange2)

}
