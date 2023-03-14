import scala.io.Source
import scala.util.{Right, Success}

class Day01Test extends munit.FunSuite {
  test("Part 1 With Invalid Input") {
    val invalidInput: String = "WHATEVA"
    val result = Day01.solvePart1(invalidInput)
    assertEquals(result, Left("Could not parse input: java.lang.NumberFormatException: For input string: \"WHATEVA\""))
  }

  test("Part 1 With Less Than 3 Elves") {
    val invalidInput: String =
      """0""".stripMargin
    val result = Day01.solvePart1(invalidInput)
    assertEquals(result, Left("At least 3 elves are needed in input"))
  }

  test("Part 1 Example") {
    val result = Day01.solvePart1(day01Example)
    assertEquals(result, Right(24000))
  }

  test("Part 1 Solution") {
    val result = Day01.solvePart1(day01Input)
    assertEquals(result, Right(69528))
  }

  test("Part 2 Example") {
    val result = Day01.solvePart2(day01Example)
    assertEquals(result, Right(45000))
  }

  test("Part 2 Solution") {
    val result = Day01.solvePart2(day01Input)
    assertEquals(result, Right(206152))
  }
}

val day01Example: String =
  """1000
    |2000
    |3000
    |
    |4000
    |
    |5000
    |6000
    |
    |7000
    |8000
    |9000
    |
    |10000
    |""".stripMargin

val day01Input: String = Source.fromFile("puzzle_inputs/day01.txt").mkString
