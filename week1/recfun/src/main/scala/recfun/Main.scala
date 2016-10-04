package recfun

import scala.annotation.tailrec

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
    def balance(chars: List[Char]): Boolean = {
      val open_paren = "("
      val close_paren = ")"

      def converter(in : List[Char]) : List[Char]= {
        val valler = in.toString()


      }

      if ( chars.isEmpty ){
        true
      }
      else if( chars filter paren == chars){
        true
      }
      else if( chars.head == singl && chars.tail == singl){
        true
      } else {
        false
      }
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
