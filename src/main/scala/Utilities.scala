import java.io.File
import scala.io.Source
import scala.reflect.io

object Utilities extends App {

  //method from utilities
  def getLinesFromFile(srcPath: String, encoding:String="UTF8"): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath, enc=encoding)
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close
    lines
  }

  //https://alvinalexander.com/scala/how-to-list-files-in-directory-filter-names-scala/ idea
  //TODO add regex, contains etc capability
  def getFileNames(folder:String, prefix:String="", suffix:String=".txt"):Array[String] = {
    val d = new File(folder)
    if (d.exists && d.isDirectory) {
      d.listFiles
        .filter(_.isFile)
        .map(_.toString)
        .filter(_.split("\\\\").last.startsWith(prefix)) //windows specific
        .filter(_.endsWith(suffix))
    } else {
      Array[String]()
    }
  }

  def saveLines(lines: Seq[String], destPath: String, sep: String = "\n"): Unit = {
    val txt = lines.mkString(sep)

    import java.io.{File, PrintWriter} //explicit import
    //import java.io._ //this was wildcard import meaning we got all of java.io library which we might not need
    val pw = new PrintWriter(new File(destPath))
    pw.write(txt)
    pw.close()
  }


}
