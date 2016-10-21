import scala.collection.mutable.Stack

val x = Stack[String]("two", "one", "three").sorted

def outer(in : Stack[String], out: List[String]) : List[String] =  {
  if (in.size > 0) {
    val opo: String = in.pop()
    val ii: List[String] = out.union(List[String](opo))
    outer(in, ii)
  }
  else out
}
val nn = outer(in = x, out = List())
nn.foreach(x => println(x + '~'))