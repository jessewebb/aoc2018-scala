package jessewebb.aoc2018.day01

import scala.annotation.tailrec

object Part2 {
  type Frequency = Int
  type FrequencyChange = String

  def solve(input: Seq[FrequencyChange]): Frequency = {
    @tailrec
    def solveRec(current: Frequency, next: Seq[FrequencyChange], seen: Set[Frequency]): Frequency = {
      next match {
        case head +: tail =>
          val newCurrent: Frequency = current + head.toInt
          if (seen.contains(newCurrent))
            newCurrent
          else
            solveRec(newCurrent, tail, seen + newCurrent)
        case Seq() =>
          solveRec(current, input, seen)
      }
    }

    solveRec(0, input, Set(0))
  }
}
