package jessewebb.aoc2018.day02

import jessewebb.aoc2018.day02.Part1._
import org.scalatest.FunSuite

class Part1Test extends FunSuite {

  test("Example BoxID #1") {
    val boxID = "abcdef"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = false, exactly3OfAnyLetter = false))
  }

  test("Example BoxID #2") {
    val boxID = "bababc"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = true, exactly3OfAnyLetter = true))
  }

  test("Example BoxID #3") {
    val boxID = "abbcde"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = true, exactly3OfAnyLetter = false))
  }

  test("Example BoxID #4") {
    val boxID = "abcccd"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = false, exactly3OfAnyLetter = true))
  }

  test("Example BoxID #5") {
    val boxID = "aabcdd"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = true, exactly3OfAnyLetter = false))
  }

  test("Example BoxID #6") {
    val boxID = "abcdee"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = true, exactly3OfAnyLetter = false))
  }

  test("Example BoxID #7") {
    val boxID = "ababab"
    val result = Part1.hasRepeatedLetters(boxID)
    assert(result === HasRepeatedLettersResult(exactly2OfAnyLetter = false, exactly3OfAnyLetter = true))
  }

  test("Example Checksum") {
    val input =
      s"""
         |abcdef
         |bababc
         |abbcde
         |abcccd
         |aabcdd
         |abcdee
         |ababab
       """.stripMargin
    val result = Part1.solve(input)
    assert(result === 12)
  }

}
