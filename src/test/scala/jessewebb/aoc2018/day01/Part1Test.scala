package jessewebb.aoc2018.day01

import org.scalatest.FunSuite

class Part1Test extends FunSuite {

  test("Example #1") {
    val input = Seq("+1", "-2", "+3", "+1")
    val result = Part1.solve(input)
    assert(result === 3)
  }

  test("Example #2") {
    val input = Seq("+1", "+1", "+1")
    val result = Part1.solve(input)
    assert(result === 3)
  }

  test("Example #3") {
    val input = Seq("+1", "+1", "-2")
    val result = Part1.solve(input)
    assert(result === 0)
  }

  test("Example #4") {
    val input = Seq("-1", "-2", "-3")
    val result = Part1.solve(input)
    assert(result === -6)
  }

}
