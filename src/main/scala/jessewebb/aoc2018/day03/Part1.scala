package jessewebb.aoc2018.day03

object Part1 {
  def solve(input: String): Int = {
    val claimStrs = input.split('\n').map(_.trim).filter(!_.isEmpty).toList
    val claims = claimStrs.map(Claim.apply)
    val markedFabric = claims.foldLeft(Fabric())(_.markClaim(_))
    markedFabric.squareInchClaimMap.values.count(_.size >= 2)
  }
}
