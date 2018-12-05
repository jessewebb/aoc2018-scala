package jessewebb.aoc2018.day03

import org.scalatest.FunSuite

class ClaimTest extends FunSuite {

  test("apply should parse example claim string") {
    val claimStr = "#123 @ 3,2: 5x4"
    val result = Claim(claimStr)
    assert(result === Claim(123, 3, 2, 5, 4))
  }

}
