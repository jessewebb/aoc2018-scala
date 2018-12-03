package jessewebb.aoc2018.day02

import org.scalatest.FunSuite

class Part2Test extends FunSuite {


  test("findTwoCorrectBoxIDs should find correct box IDs") {
    val boxIDs = Set(
      "abcde",
      "fghij",
      "klmno",
      "pqrst",
      "fguij",
      "axcye",
      "wvxyz"
    )
    val result = Part2.findTwoCorrectBoxIDs(boxIDs)
    assert(result === Some("fghij", "fguij"))
  }

  test("findTwoCorrectBoxIDs should not get fooled by out-of-order characters") {
    val boxIDs = Set(
      "nvoxmkcwtdbfiysuphzeeraljq",
      "nqosmkcwtdbfiyxuphzeeraljr"
    )
    val result = Part2.findTwoCorrectBoxIDs(boxIDs)
    assert(result === None)
  }

  test("Example") {
    val input =
      s"""
         |abcde
         |fghij
         |klmno
         |pqrst
         |fguij
         |axcye
         |wvxyz
       """.stripMargin
    val result = Part2.solve(input)
    assert(result === "fgij")
  }

}
