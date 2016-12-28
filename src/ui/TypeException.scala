package ui

import scala.util.parsing.combinator._



class TypeException(val tmsg: String = "Type error") extends JediException(tmsg)
