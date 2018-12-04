package jessewebb.aoc2018.day03

import scala.annotation.tailrec

object Part1 {
  def solve(input: String): Int = {
    val claimStrs = input.split('\n').map(_.trim).filter(!_.isEmpty).toList
    val claims = claimStrs.map(parseClaim)
    val markedFabric = claims.foldLeft(Fabric())(_.markClaim(_))
    markedFabric.squareInchClaimMap.values.count(_.size >= 2)
  }

  // map of x,y coordinates to claim IDs
  case class Fabric(squareInchClaimMap: Map[(Int, Int), Set[Int]] = Map.empty) {
    def markClaim(claim: Claim): Fabric = {
      @tailrec
      def markClaimRec(markedFabric: Fabric, c: Claim): Fabric = {
        val currentClaimMap = markedFabric.squareInchClaimMap
        val coordsToMark = (c.x, c.y)
        val mapMarkedForCoords = markedFabric.copy(currentClaimMap +
          (coordsToMark -> (currentClaimMap.getOrElse(coordsToMark, Set.empty) + c.id)))
        if (c.width > 1) {
          val claimForNextCoords = c.copy(x = c.x + 1, width = c.width - 1)
          markClaimRec(mapMarkedForCoords, claimForNextCoords)
        } else if (c.height > 1) {
          // reset x and width to act like a carriage-return through the grid
          val claimForNextCoords = c.copy(x = claim.x, y = c.y + 1, width = claim.width, height = c.height - 1)
          markClaimRec(mapMarkedForCoords, claimForNextCoords)
        } else {
          mapMarkedForCoords
        }
      }

      markClaimRec(this, claim)
    }
  }

  case class Claim(id: Int, x: Int, y: Int, width: Int, height: Int)

  private[day03] def parseClaim(claimStr: String): Claim = {
    // #123 @ 3,2: 5x4
    val regex = """\#(\d+) \@ (\d+),(\d+)\: (\d+)x(\d+)""".r
    claimStr match {
      case regex(id, x, y, width, height) => Claim(id.toInt, x.toInt, y.toInt, width.toInt, height.toInt)
      case _ => throw new IllegalArgumentException(s"claimStr: $claimStr")
    }
  }
}
