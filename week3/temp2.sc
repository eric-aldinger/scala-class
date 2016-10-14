object nth {
  def InterTheDragon(n: Int, Source: List[Any]): Any =
    try Source(n)
    catch {
      case ind: IndexOutOfBoundsException => println(ind.printStackTrace() + " ERROR")
      case e: Exception => println(e.printStackTrace())
    }
}
val s = List("One","Cabbage", "Car", "Poop")
nth.InterTheDragon(1,s)
nth.InterTheDragon(22,s)