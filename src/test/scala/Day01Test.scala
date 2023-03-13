import scala.io.Source
import scala.util.Success

class Day01Test extends munit.FunSuite {
  test("Part 1 Example") {
    val result = Day01.solvePart1(day01Example)
    assertEquals(result, Success(24000))
  }

  test("Part 1 Solution") {
    val result = Day01.solvePart1(day01Input)
    assertEquals(result, Success(69528))
  }

  test("Part 2 Example") {
    val result = Day01.solvePart2(day01Example)
    assertEquals(result, Success(45000))
  }

  test("Part 2 Solution") {
    val result = Day01.solvePart2(day01Input)
    assertEquals(result, Success(206152))
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
