package ui
import expressions._
import values._
import values._

object system {
 // the dispatcher
  def execute(operator: String, args: List[Value]) = {
    operator match {
      case "add" => add(args)
      case "mul" =>  mul(args)
      case "div" => div(args)
      case "sub" =>sub(args)
      case "equals" => equal(args)
      case "less" =>less(args)
      case "not" => not(args)
      case "great" => great(args)
      // mul, sub, div, equals, less, not,etc.
      case _ => throw new UndefinedException(operator)
    }
  }
  def add(args: List[Value]): Value = {
    // type check like crazy first
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce (_ + _))
  }
 def sub(args: List[Value]): Value = {
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce (_ - _))
  }
  def mul(args : List[Value]): Value = {
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce (_ * _))
  }
  def div(args: List[Value]): Value = {
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce (_ / _))
  }
  def equal(vals : List[Value]): Value = {
    
    val args = vals.filter(_.isInstanceOf[Number]).map(_.asInstanceOf[Number])
    
   var isEqual = true
   for ( i <- 1 until args.length)
   {
     if (args(0).value!=args(i).value) isEqual = false
   }
      if (isEqual) new Boole(true) else new Boole(false)
  }
  
  def not(vals : List[Value]): Value = {
      if (vals.isEmpty) throw new TypeException("expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Boole])
    if (ok.length < vals.length) throw new TypeException("inputs must be Boolean")
      if (vals.length>1) throw new TypeException(" Too many arguements")
    val args2 = vals.map(_.asInstanceOf[Boole])
    new Boole(!args2(0).value)
  }
   def less(vals : List[Value]): Value = {
   
    val args = vals.map(_.asInstanceOf[Number])
    var isLess = true
    
    for ( i <- 1 until args.length){
      if (args(i-1).value >=args(i).value) isLess=false
    }
    if (isLess) new Boole(true) else new Boole(false)
  }
   def great(vals : List[Value]): Value = {
    
    val args = vals.map(_.asInstanceOf[Number])
    var isGreat = true
    
    for ( i <- 1 until args.length){
      if (args(i-1).value <=args(i).value) isGreat=false
    }
    if (isGreat) new Boole(true) else new Boole(false)
  }
}