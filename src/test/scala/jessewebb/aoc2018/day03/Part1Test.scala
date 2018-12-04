package jessewebb.aoc2018.day03

import jessewebb.aoc2018.day03.Part1._
import org.scalatest.FunSuite

class Part1Test extends FunSuite {

  test("parseClaim Example") {
    val claim = "#123 @ 3,2: 5x4"
    val result = Part1.parseClaim(claim)
    assert(result === Claim(123, 3, 2, 5, 4))
  }

  test("Fabric.markClaim single square inch") {
    val fabric = Fabric()
    val claim = Claim(1, 1, 1, 1, 1)
    val result = fabric.markClaim(claim)
    assert(result === Fabric(Map((1,1) -> Set(1))))
  }

  test("Fabric.markClaim 2x2") {
    val fabric = Fabric()
    val claim = Claim(2, 2, 2, 2, 2)
    val result = fabric.markClaim(claim)
    assert(result === Fabric(Map(
      (2,2) -> Set(2), (3,2) -> Set(2),
      (2,3) -> Set(2), (3,3) -> Set(2)
    )))
  }

  test("Fabric.markClaim overlap") {
    val fabric = Fabric()
    val claim1 = Claim(1, 1, 3, 4, 4)
    val claim2 = Claim(2, 3, 1, 4, 4)
    val claim3 = Claim(3, 5, 5, 2, 2)
    val result = fabric.markClaim(claim1).markClaim(claim2).markClaim(claim3)
    assert(result === Fabric(Map(
                                          (3, 1) -> Set(2),   (4, 1) -> Set(2),   (5, 1) -> Set(2), (6, 1) -> Set(2),
                                          (3, 2) -> Set(2),   (4, 2) -> Set(2),   (5, 2) -> Set(2), (6, 2) -> Set(2),
      (1, 3) -> Set(1), (2, 3) -> Set(1), (3, 3) -> Set(1,2), (4, 3) -> Set(1,2), (5, 3) -> Set(2), (6, 3) -> Set(2),
      (1, 4) -> Set(1), (2, 4) -> Set(1), (3, 4) -> Set(1,2), (4, 4) -> Set(1,2), (5, 4) -> Set(2), (6, 4) -> Set(2),
      (1, 5) -> Set(1), (2, 5) -> Set(1), (3, 5) -> Set(1),   (4, 5) -> Set(1),   (5, 5) -> Set(3), (6, 5) -> Set(3),
      (1, 6) -> Set(1), (2, 6) -> Set(1), (3, 6) -> Set(1),   (4, 6) -> Set(1),   (5, 6) -> Set(3), (6, 6) -> Set(3)
    )))
  }

  test("Example") {
    val input =
      s"""
         |#1 @ 1,3: 4x4
         |#2 @ 3,1: 4x4
         |#3 @ 5,5: 2x2
       """.stripMargin
    val result = Part1.solve(input)
    assert(result === 4)
  }
}
