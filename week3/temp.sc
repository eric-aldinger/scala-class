trait ConsList[T] {
  def isEmpty: Boolean
  def fetchHead: T
  def fetchTail: ConsList[T]
}

class Cons[T](val fetchHead: T, val fetchTail: ConsList[T]) extends ConsList[T]{
  def isEmpty: Boolean = false
  //head and tail defs are implemented in the constructor as vals.

}
class Nil[T] extends ConsList[T]{
  def isEmpty: Boolean = true
  def fetchHead: Nothing = throw new NoSuchElementException("Nil.fetchHead")
  def fetchTail: Nothing = throw new NoSuchElementException("Nil.fetchTail")
}

object nth {
  def x: Exception = new NoSuchElementException
  def InterTheDragon[T](n: Int, Source: ConsList[T]): T =
    //try {
      if (Source.isEmpty) throw new IndexOutOfBoundsException
      else if (n==0)
        Source.fetchHead
      else InterTheDragon(n - 1, Source.fetchTail)
}
val s : ConsList[Int]= new Cons(1, new Cons(2, new Cons(3, new Nil)))
nth.InterTheDragon(1,s)
nth.InterTheDragon(-1,s)

//look, type erasure where the compiler inferred the type

def cons_server(elem: Any) = new Cons(elem, new Nil)
val x = cons_server("Fuck")
x.fetchHead
x.fetchTail
x.isEmpty
val y = cons_server(1,2,3)
y.fetchHead
y.fetchTail
