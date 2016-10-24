val n : List[Any] = List(1,2,3,4,5)

val x = 1 :: 2  :: 3 :: List[Any]("4", 5)

n == x

type l = Int
type a = List[l]

def insert(x: Int, xs: a): a = xs match{
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}

insert(7, List(1,2,3,4))
insert(7, List(1,200,3,77))
insert(3, (insert(200, List(1, 3,7, 77))))



abstract class CodeTree

case class Fork(left:CodeTree, right:CodeTree, chars: List[Char], weight: Int )
extends CodeTree

case class Leaf(char: Char, wieght:Int) extends CodeTree