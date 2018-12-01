package jessewebb.aoc2018.day01

import org.scalatest.FunSuite

class Part2Test extends FunSuite {

  test("Example #1") {
    val input = Seq("+1", "-2", "+3", "+1")
    val result = Part2.solve(input)
    assert(result === 2)
  }

  test("Example #2") {
    val input = Seq("+1", "-1")
    val result = Part2.solve(input)
    assert(result === 0)
  }

  test("Example #3") {
    val input = Seq("+3", "+3", "+4", "-2", "-4")
    val result = Part2.solve(input)
    assert(result === 10)
  }

  test("Example #4") {
    val input = Seq("-6", "+3", "+8", "+5", "-6")
    val result = Part2.solve(input)
    assert(result === 5)
  }

  test("Example #5") {
    val input = Seq("+7", "+7", "-2", "-7", "-4")
    val result = Part2.solve(input)
    assert(result === 14)
  }

}
