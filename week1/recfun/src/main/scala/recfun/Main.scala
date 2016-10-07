package recfun

import scala.annotation.tailrec
import scala.util.matching
import scala.util.matching.Regex

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if( r == 0 || r == 1 || c == 0 || r==c ) {
      1
    } else {
      //otherwise call self with
      pascal(r -1, c - 1) + pascal(r -1, c)
    }
  }
  
  /**
   * Exercise 2
   */
  /*def balance(x: List[Char]): Boolean = {
    val open  = x.indexOf('(')
    val close = x.lastIndexOf(')')
    val hasBalance = open < close
    val hasOpen = x.contains('(')
    val hasClose = x.contains(')')

    if (!hasOpen && !hasClose)
    {true}
    else if (!hasOpen && hasClose)
    {false}
    else if (hasOpen && !hasClose)
    {false}
    else if (!hasBalance)
    {false}
    else if (hasOpen && hasClose && hasBalance ) {
      val split = x.splitAt(open)._2.splitAt(close)._1
      balance(split)
    }
    else true
  }*/

  def balance(x: List[Char]): Boolean = {
    val isClean = x.length == 0 || (! x.contains('(') && ! x.contains(')'))
    val open = x.indexOf('(')
    val close = x.indexOf(')')
    val openLast = x.lastIndexOf('(')
    val closeLast = x.lastIndexOf(')')
    val hasBalance = open < close && openLast < closeLast
    val ref = List('(', ')')
    val validate = x.intersect(ref) == ref

    isClean || (hasBalance && validate)
  }


  /**
   * Exercise 3
   */
//    def countChange(money: Int, coins: List[Int]): Int = ???
  }
