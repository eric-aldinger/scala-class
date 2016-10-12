import math.abs


def isNeg(In: Double) : Boolean  = {
  In != abs(In)
}

type Set = Int => Boolean
def contains(set: Set, elem: Int) : Boolean  = {
  set(elem)
}
isNeg(3); isNeg(-3.01);contains(Set(1,2,3), -3)

class Rational(num: Int, den:Int){
  require(den != 0, "denominators cannot be zero") //throws illegal argument exception
  def this(x: Int) = this(x,1) //alternate constructor

  private def commonDivisor(a: Int, b:Int): Int = if (b ==0 )a else commonDivisor(b, a%b)
  private val common = commonDivisor(num, den)

  val numer = num / commonDivisor(num, den)
  val denom = den / commonDivisor(num, den)

  def add(in: Rational) =
    new Rational(
      numer * in.denom + in.numer * denom,
      denom * in.denom
    )

  def unary_- : Rational = new Rational(- numer , denom)
  def sub(in: Rational) = add(in unary_-)
  def < (in:Rational) = numer * in.denom < in.numer * denom
  def max(that: Rational) = if (this < that) that else this
}

def makeString(r: Rational)={ r.numer + "/" + r.denom}

def addRational(r1: Rational, r2:Rational): Rational =
  new Rational(
    r1.numer * r2.denom + r2.numer * r1.denom,
    r1.denom * r2.denom
  )

  makeString(addRational(r1 = new Rational(1, 2), r2 = new Rational(2, 3)))
  val y = new Rational(2, 3)
  makeString(y.add(new Rational(3, 4)))
  makeString(- y)
  makeString{y.add(y)}

println("\n" +
  "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd")
trait thing{val x = 20}
val n = new Rational(1,2) with thing
n.x
val m = new Rational(1,22)
makeString(n add m)
makeString(- n)
n < m

val whole = new Rational(12)
makeString(- whole)