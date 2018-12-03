package jessewebb.aoc2018.day02

object Part1 {
  def solve(input: String): Int = {
    val boxIDs = input.split('\n').map(_.trim).toList
    val results = boxIDs.map(hasRepeatedLetters)
    val numBoxIDsWithExactly2OfAnyLetter = results.count(_.exactly2OfAnyLetter)
    val numBoxIDsWithExactly3OfAnyLetter = results.count(_.exactly3OfAnyLetter)
    numBoxIDsWithExactly2OfAnyLetter * numBoxIDsWithExactly3OfAnyLetter
  }

  private[day02] case class HasRepeatedLettersResult(exactly2OfAnyLetter: Boolean, exactly3OfAnyLetter: Boolean)

  private[day02] def hasRepeatedLetters(boxID: String): HasRepeatedLettersResult = {
    val letterCounts = countLetters(boxID)
    HasRepeatedLettersResult(
      exactly2OfAnyLetter = letterCounts.values.exists(_ == 2),
      exactly3OfAnyLetter = letterCounts.values.exists(_ == 3)
    )
  }

  private[day02] def countLetters(boxID: String): Map[Char, Int] = {
    boxID.foldLeft[Map[Char, Int]](Map.empty) {
      (acc, letter) => acc + (letter -> (acc.getOrElse(letter, 0) + 1))
    }
  }
}
