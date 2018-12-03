package jessewebb.aoc2018.day02

object Part2 {
  def solve(input: String): String = {
    val boxIDs = input.split('\n').map(_.trim).toSet
    val correctBoxIDs = findTwoCorrectBoxIDs(boxIDs).get
    correctBoxIDs._1 intersect correctBoxIDs._2
  }

  private[day02] def findTwoCorrectBoxIDs(boxIDs: Set[String]): Option[(String, String)] = {
    boxIDs.foreach(boxID => {
      val otherBoxIDs = boxIDs - boxID
      val matchingBoxID = findBoxIdWhichDiffersByExactlyOneCharacter(boxID, otherBoxIDs)
      if (matchingBoxID.isDefined) return Some(boxID, matchingBoxID.get)
    })
    None
  }

  private[day02] def findBoxIdWhichDiffersByExactlyOneCharacter(boxID: String, otherBoxIDs: Set[String]): Option[String] = {
    // otherBoxIDs.find(boxID.diff(_).length == 1) // diff doesn't work because it seems to ignore order
    otherBoxIDs.find(boxID.zip(_).count(chars => chars._1 != chars._2) == 1)
  }
}
