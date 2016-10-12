import math.abs

object test{
  val tolerance = 0.0001
  def aprox(x:Double, y:Double) = abs((x - y) / x ) < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double ={
      println("guess: " + guess)
      val next = f(guess)
      if (aprox(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  fixedPoint(x => 1 + x/2)(4)
  println("jkjkjkjkjkjkjkjkj")

  //def sqr(in:Double) = fixedPoint(f =>  (f + in / f )(1)
  // because the function above did not work so well, vacilating between two values,
  //we want instead to average the prior result with the current estimate to provide
  // a closer aproximation
  def stablAvg(f: Double  => Double)(in: Double) : Double = ((in + f(in))/ 2)
  def sqr(in: Double) = fixedPoint( (stablAvg(y => in / y)) )(1)
  sqr(2)

  println("aaaaaaaaaaaaaaaaaa")
  //recursive accumulating function
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a +1 , f(a) + acc)
    }
    loop(a, 0)
  }
  // standard method definition
  def double(x: Int) : Int = {x + x}
  //partially applied function
  def doubleSum =  sum( (double) ) _
  double(8)
  doubleSum(1,8)

  //different way to define the function
  def triple = {x : Int => x + x + x}
  //can still make a partially applied function
  def tripleSum =  sum( (triple) ) _
triple(8)
tripleSum(1,8)

  //fully applied function with an anonymous function parameter
  sum (x => x + x + x) (1,8)

  def reduct(f: Int => Int, recurse: (Int, Int) => Int , zero: Int)(iteration : Int, end:Int): Int = {
      if (iteration > end)  zero
      else recurse(f(iteration), reduct(f , recurse , zero)(iteration + 1 , end))
    }

  def mather(f: Int => Int)(c: Int, d: Int) : Int = reduct(f, (x, y) => x * y, 1)(c,d)

  //partially applied
  //define this to reuse a compact form over and over
  def product  = mather(x => x * x) _
  product(3,4)
  //anonymous
  //define this for a one or two instances of use
  //makes it inaccessible for testing
  mather(x => x * x)(3,4)

  def sum  = mather(x => x + x) _
  product(3,4)
  mather(x => x + x)(3,4)

  def fact(n:Int) = mather(x => x)(1,n)
  fact(5)
  mather(x => x)(1,5)

  //fixed point
  fact(1)

  println("Death Death Death Death Death Death Death Death ")
}