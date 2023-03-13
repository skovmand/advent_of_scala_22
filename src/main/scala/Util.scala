import scala.io.StdIn

object Util {
  def readStdinToString(): String = {
    Iterator
      .continually(StdIn.readLine())
      .takeWhile(_ != null)
      .mkString("\n")
  }
}
