import scala.util.matching.Regex

def balance(chars: List[Char]): Boolean = {
  def converter(in: List[Char]): List[Char] = {
    val stringstream: Stream[List[Char]] = Stream(in)
//TODO: split on (
    //TODO parse each end
    //Todo recurse
    in //shim
  }
  converter(chars)
  false//shim
}

def converter(in: String) = {
  val r = """\b[b-df-hj-np-tv-z]*[aeiou]+[b-df-hj-np-tv-z]*\b""".r
  val regex = """[a-z, A-Z, " "]*[(][a-z, A-Z, " "]*[)][a-z, A-Z, " "]*""".r
  regex.pattern.matcher(in).matches
}

val xx = """as (s) as"""
converter(xx)
balance(xx.toList)

/*import scala.annotation.tailrec

@tailrec def factorial(n: Int, result: Int = 0): Int = {
  require(n > 0, "message is that you tried to use a negative int")

  if (result == 0 && n < 2){
    1
  }
  else if ( n < 2 ){
    result
  }
  else {
    val res = n * (n - 1) + result
    factorial(n-1,res)
  }
}

factorial(200)*/