package advent_of_scala_2022

import scala.io.StdIn

@main def myProgram(): Unit = {
  val input =
    Iterator
      .continually({
        val line = StdIn.readLine()
        println(line)
        line
      })
      .takeWhile(_ != null)
      .mkString("\n")

  println("HERE IS THE INPUT!")
  println(input)
  println("END OF INPUT")

  val parsedInput = parseInput(input)

  val result = findElfWithMaxCalories(parsedInput)

  println(result)
}

def parseInput(input: String): Vector[Vector[Int]] = {
  input.split("\n\n").toVector.map(x => parseIndividualElf(x))
}

def findElfWithMaxCalories(elfItemCalories: Vector[Vector[Int]]): Int = {
  elfItemCalories
    .map(_.sum)
    .max
}

def parseIndividualElf(caloriesString: String): Vector[Int] = {
  caloriesString
    .split("\n")
    .map(x => x.toInt)
    .toVector
}
