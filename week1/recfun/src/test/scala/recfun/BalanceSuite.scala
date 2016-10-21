package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: Predef.augmentString(\"((hello)there)you)\").toList)") {
    val in = Predef.augmentString("((hello)there)you)").toList
    val _sut = balance(in)
    assert(_sut == false)
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

}
