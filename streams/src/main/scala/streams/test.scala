package streams


trait Show[A]:
  def apply(a: A): String

object Show:
  given showInt: Show[Int] with
    def apply(n: Int): String = s"Int($n)"



@main def runTest(): Unit =
    println(implicitly[Show[Int]].apply(42))

