import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Day01 {
  def main(args: Array[String]): Unit = {
    val input = Util.readStdinToString()

    Try(input)
      .flatMap(parseInput)
      .flatMap(findElfWithMaxCalories) match {
      case Success(solution) => {
        println(
          "Part 1: Elf with max calories is " + solution
        )
      }
      case Failure(exception) => {
        throw new RuntimeException("Could not solve puzzle", exception)
      }
    }
  }

  private def parseInput(input: String): Try[Vector[Vector[Int]]] = {
    Try {
      input
        .split("\n\n")
        .toVector
        .map(
          _.split("\n")
            .map(_.toInt)
            .toVector
        )
    }
  }

  private def findElfWithMaxCalories(elfItemCalories: Vector[Vector[Int]]): Try[Int] = {
    Try {
      elfItemCalories
        .map(_.sum)
        .max
    }
  }
}
