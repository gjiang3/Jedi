package expressions
import values._
import ui._
case class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {

  def execute(env: Environment): Value = {
      val args = operands.map(_.execute(env))
      
      if (env.contains(operator)) {
      // apply operator to args starting in Wookie
      null
    } else {
      
      system.execute(operator.value, args)
      
    }  
  }
}