object StringOperation extends App {

  val n = 10000
  val tokens = Seq("dog", "cat", "eat", "bite")

  var text = ""
  val t0 = System.nanoTime()
  for (_ <- 1 to n) {
    text += tokens(1)
  }
  val t1 = System.nanoTime()

  val textBuffer = new StringBuilder
  val t2 = System.nanoTime()
  for (_ <- 1 to n) {
    textBuffer.append(tokens(1))
  }
  val t3 = System.nanoTime()

  val textDelta = t1-t0
  val textBufferDelta = t3-t2

  println(s"Text Delta          $textDelta")
  println(s"TextBuffer Delta    $textBufferDelta")
}
