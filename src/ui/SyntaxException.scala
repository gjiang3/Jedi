package ui

import scala.util.parsing.combinator._

class SyntaxException(val result: Parsers#Failure) extends JediException("Syntax error")