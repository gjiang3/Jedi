package ui

import scala.util.parsing.combinator._


class UndefinedException(val symbol: String) 
   extends JediException("Undefined identifier: " + symbol)

