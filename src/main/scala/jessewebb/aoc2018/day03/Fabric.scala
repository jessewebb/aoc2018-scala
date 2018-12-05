package jessewebb.aoc2018.day03

import scala.annotation.tailrec

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
