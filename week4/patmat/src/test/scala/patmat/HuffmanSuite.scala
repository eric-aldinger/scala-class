package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
    assert(makeOrderedLeafList(List(('b', 2), ('a', 1), ('c', 3))) === List(Leaf('a',1), Leaf('b',2), Leaf('c',3)))
    assert(makeOrderedLeafList(List(('m', 2), ('g', 1), ('z', 3))) === List(Leaf('g',1), Leaf('m',2), Leaf('z',3)))
    assert(makeOrderedLeafList(List(('m', 1), ('m', 1), ('z', 2))) === List(Leaf('m',1), Leaf('m',1), Leaf('z',2)))
  }


  test("singleton of fork is false")
  {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)

    assert(singleton(List(t1, t2)) == false)
  }

  test("singleton of single leaf is true")
  {
    val t1 = List(Leaf('a',2))
    assert(singleton(t1) == true)
  }

  test("singleton of empty is true")
  {
    val t1 = List()
    assert(singleton(t1) == true)
  }

  test("singleton of two leaf list is false")
  {
    val t1 = List(Leaf('a',2),Leaf('a',2))
    assert(singleton(t1) == false)
  }

  test("combine two node leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2))
    assert(combine(leaflist) === leaflist)
  }

  test("combine empty leaf list") {
    val leaflist: List[CodeTree] = List()
    assert(combine(leaflist) === leaflist)
  }

  test("combine of multi leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
