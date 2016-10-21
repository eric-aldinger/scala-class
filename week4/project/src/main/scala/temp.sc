package week4

abstract class Nat{
def isZero: Boolean
def pre: Nat
def next: Nat  = new nexter(this)
def +(that: Nat): Nat
def -(that: Nat): Nat
}

object Zero extends Nat{
  def isZero = true
  def pre = throw new Error
  def +(that: Nat) = that
  def -(that: Nat) =
    if(that.isZero) this else throw new Error
}

class nexter(n:Nat) extends Nat{
  def isZero = false
  def pre = n
  def +(that: Nat): Nat = new nexter(n + that)
  def -(that: Nat): Nat =
    if(that.isZero) this else n - that.pre
  def returner = this == n
}

