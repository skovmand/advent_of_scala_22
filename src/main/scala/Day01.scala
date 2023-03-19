import scala.io.StdIn
import scala.util.{Failure, Success, Try}

@main def Day01(): Unit =
  val input = Util.readStdinToString()

  solvePart1(input) match
    case Right(answer) => println(s"Part 1: Elf with max calories is $answer")
    case Left(reason)  => println("Could not solve day 1 part 1: " + reason)

  solvePart2(input) match
    case Right(answer) => println(s"Part 2: Sum of calories for top three Elves is $answer")
    case Left(reason)  => println("Could not solve day 1 part 2: " + reason)

// Part 1

def solvePart1(input: String): Either[String, Int] =
  parseInput(input)
    .flatMap(findElfWithMaxCalories)

private def findElfWithMaxCalories(elfItemCalories: Vector[Vector[Int]]): Either[String, Int] =
  try
    Right(
      elfItemCalories
        .map(_.sum)
        .max
    )
  catch case _: UnsupportedOperationException => Left("Could not find a maximum")

// Part 2

def solvePart2(input: String): Either[String, Int] =
  parseInput(input)
    .map(findTop3Elves)

private def findTop3Elves(elfItemCalories: Vector[Vector[Int]]): Int =
  elfItemCalories
    .map(_.sum)
    .sortWith(_ > _)
    .take(3)
    .sum

// Parsing

private def parseInput(input: String): Either[String, Vector[Vector[Int]]] =
  try
    val parsed = input
      .split("\n\n")
      .toVector
      .map(
        _.split("\n")
          .map(_.toInt)
          .toVector
      )

    if (parsed.length < 3) {
      Left("At least 3 elves are needed in input")
    } else {
      Right(parsed)
    }
  catch case e: Exception => Left("Could not parse input: " + e.toString)
