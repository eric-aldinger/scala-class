package week3

object Hello {
  def main(args: Array[String]) = {
    println("khadshjfahjksfkh")
    val setter = new NonEmpty(element = 7, left = new NonEmpty(element = 20, left = Empty, right = Empty), right = Empty)
    assert(setter.contains(7) == true)
    println(setter.toString)
    //assert(setter.contains(20) == true)
  }
}