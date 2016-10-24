import patmat.Huffman.{Fork, Leaf, _}

val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)

val `1` = makeCodeTree(Leaf('a',2), t1)
weight(`1`)

def createCodeTreeTwo(chars: List[Char]): CodeTree = {

  chars.foreach(println(_))
  val tree1 = Leaf(chars.head,1)
  val x = chars.tail
  val y = x.head
  val z = x.tail
  val tree2 = Fork(Leaf(x.head, 1), Leaf(y, 2), z, chars.length )

  makeCodeTree(tree1, tree2)
}

val in: List[Char] = "I am the hunter of the holy pray".toList
createCodeTreeTwo(in)

