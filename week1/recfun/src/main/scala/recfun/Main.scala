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
    if( c == 0 || r ==0 || r == c ) {
      1
    } else {
      //otherwise call self with
      pascal(r -1, c - 1) + pascal(r -1, c)
    }
  }
  
  /**
   * Exercise 2
   */

  def balance(x: List[Char]): Boolean = {
    val ref = List('(', ')')
    val hasBasicBalance = x.count(_== ref(0)) == x.count(_== ref(1))
    //( x contains '(' ) && ( x contains ')' )
    val noParens = ! ( x contains '(' ) && ! ( x contains ')' )
    val isClean = x.length == 0 || noParens
    val open = x.indexOf('(')
    val close = x.indexOf(')')
    val openLast = x.lastIndexOf('(')
    val closeLast = x.lastIndexOf(')')
    val hasBalance = open < close && openLast < closeLast && hasBasicBalance
    val validate = x.intersect(ref) == ref

    isClean || (hasBalance && validate)
  }


  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def count(total: Int, unsortedcoins: List[Int]): Int = {
        val coins = unsortedcoins.sorted
        if (coins.isEmpty)
          0
        else if ( (total - coins.head) == 0)
          1
        else if ( (total - coins.head) < 0)
          0
        else count(total - coins.head, coins) + count(total, coins.tail)
      }

      count(money, coins)
    }
  }
