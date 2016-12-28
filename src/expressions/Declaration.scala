package expressions
import values._

case class Declaration(id: Identifier, init: Expression) extends SpecialForm {
   def execute(env: Environment): Value =  {
     // add a new row to env
     env.put(id, init.execute(env))
     Notification.DONE
   }
}
