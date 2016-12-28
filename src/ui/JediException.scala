package ui

import scala.util.parsing.combinator._

class JediException(val msg: String = "Your force is weak") extends Exception(msg)