package values
import expressions._
import scala.collection.mutable
import scala.collection.mutable.HashMap



case class Environment(nextEnv : Environment = null) extends mutable.HashMap[Identifier,Value] with Value{	

 
  def put(names: List[Identifier], vals: List[Value]) {
   for (i <- 0 until Math.min(names.length,vals.length))
   {
     put(names(i), vals(i))
   } 
  }

}
