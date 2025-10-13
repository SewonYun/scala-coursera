def abs(x:Double) = if (x < 0) -x else x


def sqrt(x: Double) = 
  def isGoodEnough(guess: Double): Boolean = 
    abs(guess * guess - x) < 0.001
  
  def improve(guess: Double) = (guess + x / guess) / 2

  @annotation.tailrec
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  sqrtIter(1.0)
end sqrt

@main def test = print(sqrt(2.0))

// sqrt(2.0)

// // 0.001
// sqrt(0.001)

// // 0.1e-20
// sqrt(0.1e-20)

// // 1.0e20
// sqrt(1.0e20)

// // 1.0e50
// sqrt(1.0e50)