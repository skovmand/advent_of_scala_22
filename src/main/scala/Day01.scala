import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Day01 {
  def main(args: Array[String]): Unit = {
    val input = Util.readStdinToString()

    solvePart1(input) match {
      case Success(solution) => {
        println(s"Part 1: Elf with max calories is $solution")
      }
      case Failure(exception) => {
        throw new RuntimeException("Could not solve puzzle", exception)
      }
    }
  }

  private def solvePart1(input: String): Try[Int] = {
    Try(input)
      .flatMap(parseInput)
      .flatMap(findElfWithMaxCalories)
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
