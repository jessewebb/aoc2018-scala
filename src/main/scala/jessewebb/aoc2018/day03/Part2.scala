package jessewebb.aoc2018.day03

object Part2 {
  def solve(input: String): Int = {
    val claimStrs = input.split('\n').map(_.trim).filter(!_.isEmpty).toList
    val claims = claimStrs.map(Claim.apply)
    val markedFabric = claims.foldLeft(Fabric())(_.markClaim(_))
    val claimIDsWithOverlap = markedFabric.squareInchClaimMap.values.filter(_.size >= 2).flatten.toSet
    val idOfClaimThatDoesntOverlap = markedFabric.squareInchClaimMap.find(entry =>
      entry._2.size == 1 && !claimIDsWithOverlap.contains(entry._2.head)).get._2.head
    idOfClaimThatDoesntOverlap
  }
}
