package jessewebb.aoc2018.day03

import org.scalatest.FunSuite

class Part2Test extends FunSuite {

  test("Example") {
    val input =
      s"""
         |#1 @ 1,3: 4x4
         |#2 @ 3,1: 4x4
         |#3 @ 5,5: 2x2
       """.stripMargin
    val result = Part2.solve(input)
    assert(result === 3)
  }
}
