package org.skovmand.AdventOfScala22

import scala.io.StdIn

@main def solve(): Unit = {
  try {
    val input =
      Iterator
        .continually(StdIn.readLine())
        .takeWhile(_ != null)
        .mkString("\n")

    val parsedInput = parseInput(input)
    val result = findElfWithMaxCalories(parsedInput)

    println("Solution to part 1: " + result)
  } catch {
    case e: Exception =>
      throw new RuntimeException("An error occured: " + e.toString)
  }
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
