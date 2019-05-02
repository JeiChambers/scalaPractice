import com.sun.tools.corba.se.idl.EnumEntry
import scala.io.{StdIn, Stdln}
import scala.util.Random


sealed trait Move extends EnumEntry
object Move extends Enum[Move] {
  val values = findValues

  case object Scissors extends Move
  case object Paper extends Move
  case object Rock extends Move
}

implicit val moveOrdering: Ordering[Move] = new Ordering[Move]{
  def compare(x: Move, y: Move): Int = {
    x match {
      case Move.Scissors if y == Move.Paper => 1
      case Move.Scissors if y == Move.Rock => -1
      case Move.Scissors => 0
      case Move.Rock if y == Move.Paper => -1
      case Move.Rock if y == Move.Scissors => 1
      case Move.Rock => 0
      case Move.Paper if y == Move.Scissors => -1
      case Move.Paper if y == Move.Rock => 1
      case Move.Paper => 0
    }
  }
}

def stateFunc(current: GameState): GameState = {
  val playerMove: Move = Move.withName(StdIn.readLine())
  val aiMove: Move = Random.shuffle(Move.values).head

  val updated = current.logic(playerMove, aiMove)
  updated.endOfRoundNotify()
  updated
}

case class GameState(p1Score: Int, p2Score: Int) {
  def logic(p1Input: Move, p2Input: Move): GameState = {
    import moveOrdering._
    val result: GameState =
      if(p1Input > p2Input)
        copy(p1Score = p1Score + 1)
      else if(p1Input == p2Input)
        copy()
      else
        copy(p2Score = p2Score + 1)

    result
  }

  def endOfRoundNotify(): Unit = {
    println(s"Player's Score: $p1Score  Computer's Score: $p2Score")
  }
}