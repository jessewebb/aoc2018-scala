package jessewebb.aoc2018.day03

object Claim {
  def apply(claimStr: String): Claim = {
    // #123 @ 3,2: 5x4
    val regex = """\#(\d+) \@ (\d+),(\d+)\: (\d+)x(\d+)""".r
    claimStr match {
      case regex(id, x, y, width, height) => Claim(id.toInt, x.toInt, y.toInt, width.toInt, height.toInt)
      case _ => throw new IllegalArgumentException(s"claimStr: $claimStr")
    }
  }
}

case class Claim(id: Int, x: Int, y: Int, width: Int, height: Int)
