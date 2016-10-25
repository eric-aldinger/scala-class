type A = Int
type B = Double
type c = List[A]
type d = List[B]

val s : A = 123
val d : B = 13.1

assert(s.getClass.getSuperclass == d.getClass.getSuperclass)
assert(s.getClass == d.getClass)

//functions are contravarient in their arguments
// and covariant in their result type
trait Function1[-T, +U]{ def apply (x: T): U}

//covariant type parms can only appear in method results
//contravariant type parms can only appear in method parms
//invarients are always welcome everywhere