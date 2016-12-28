package expressions
import values._
import ui._

import ui.UndefinedException
import javax.management.Notification
case class Identifier(value: String) extends Expression{
def execute( env : Environment) = 
  if (env.contains(this)) env(this) else throw new UndefinedException(value)
}