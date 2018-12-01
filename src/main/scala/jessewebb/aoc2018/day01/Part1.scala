package jessewebb.aoc2018.day01

object Part1 {
  type Frequency = Int
  type FrequencyChange = String

  def solve(input: Seq[FrequencyChange]): Frequency = {
    input.foldLeft(0)(_ + _.toInt)
  }
}
