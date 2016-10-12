val x : List[Char] = "())(".toList
val open = x.indexOf('(')
val close = x.indexOf(')')
val openLast = x.lastIndexOf('(')
val closeLast = x.lastIndexOf(')')
val hasBalance = open < close && openLast < closeLast
val ref = List('(', ')')
val validate = x.intersect(ref) == ref


//x.filter(x => x.contains(')'))

def balance(x: List[Char]): Boolean = {
  val isClean = x.length == 0 || (! x.contains('(') && ! x.contains(')'))
  val open = x.indexOf('(')
  val close = x.indexOf(')')
  val hasBalance = open < close
  val ref = List('(', ')')
  val validate = x.intersect(ref) == ref

  isClean || (hasBalance && validate)
}

balance(x)
import scala.annotation.tailrec

@tailrec def factorial(n: Int, result: Int = 0): Int = {
  require(n > 0, "message is that you tried to use a negative int")

  if (result == 0 && n < 2){
    1
  }
  else if ( n < 2 ){
    result
  }
  else {
    val res = n * (n - 1) + result
    factorial(n-1,res)
  }
}

factorial(5)

