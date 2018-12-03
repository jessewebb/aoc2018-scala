package jessewebb.aoc2018

import scala.io.Source

object Program extends App {

  def solveDay01(): Unit = {
    println("Day 01\n======")
    import jessewebb.aoc2018.day01._
    val inputResource = "inputs/day01.txt"
    val inputStream = getClass.getClassLoader.getResourceAsStream(inputResource)
    val input = Source.fromInputStream(inputStream).mkString
    val frequencies = input.split('\n').map(_.trim).toList
    val solution1 = Part1.solve(frequencies)
    println(s"Part 1: $solution1")
    val solution2 = Part2.solve(frequencies)
    println(s"Part 2: $solution2")
    println()
  }

  def solveDay02(): Unit = {
    println("Day 02\n======")
    import jessewebb.aoc2018.day02._
    val inputResource = "inputs/day02.txt"
    val inputStream = getClass.getClassLoader.getResourceAsStream(inputResource)
    val input = Source.fromInputStream(inputStream).mkString
    val solution1 = Part1.solve(input)
    println(s"Part 1: $solution1")
//    val solution2 = Part2.solve(input)
//    println(s"Part 2: $solution2")
    println()
  }

  solveDay01()
  solveDay02()

}
