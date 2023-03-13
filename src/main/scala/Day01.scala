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
        throw new RuntimeException("Could not solve day 1 part 1", exception)
      }
    }

    solvePart2(input) match {
      case Success(solution) => {
        println(s"Part 2: Sum of calories for top three Elves is $solution")
      }
      case Failure(exception) => {
        throw new RuntimeException("Could not solve day 1 part 2", exception)
      }
    }
  }

  // Part 1

  private def solvePart1(input: String): Try[Int] = {
    Try(input)
      .flatMap(parseInput)
      .flatMap(findElfWithMaxCalories)
  }

  private def findElfWithMaxCalories(elfItemCalories: Vector[Vector[Int]]): Try[Int] = {
    Try {
      elfItemCalories
        .map(_.sum)
        .max
    }
  }

  // Part 2

  private def solvePart2(input: String): Try[Int] = {
    Try(input)
      .flatMap(parseInput)
      .map(findTop3Elves)
  }

  private def findTop3Elves(elfItemCalories: Vector[Vector[Int]]): Int = {
    elfItemCalories
      .map(_.sum)
      .sortWith(_ > _)
      .take(3)
      .sum
  }

  // Parsing

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
}
