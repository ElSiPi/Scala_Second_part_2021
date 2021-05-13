object HelloScalaTwo extends App {
    println("Hello again!")

    val myNumbers = (1 to 100).toArray

    val myBigNumbers = myNumbers.map(n => n*200)
    myBigNumbers.slice(0, 4).foreach(println)
}
