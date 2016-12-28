package values
import expressions.Literal

case class Boole(value: Boolean) extends Literal {
  override def toString() = value.toString
}