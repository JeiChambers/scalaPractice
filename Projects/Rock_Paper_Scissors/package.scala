package RockPaperScissors

import scala.annotation.tailrec



object funkLoop{

  def funkLoop[T](predicate: T => Boolean, block: T => T, initial: T): T = {
    println(s"initial => $initial")

    @tailrec
    def recurse(p: T => Boolean, b: T => T, agg: T): T = {
    println(s"recurse - agg => $agg")
    if(!predicate(agg)) agg
    else {
    val updatedAgg: T = b.apply(agg)
    recurse(p, b, updatedAgg)
    }
    }

    recurse(predicate, block, initial)
  }
}