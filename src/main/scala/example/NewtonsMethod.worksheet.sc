def abs(x:Double) = if (x < 0) -x else x



def isGoodEnough(guess: Double, x: Double): Boolean = 
  abs(guess * guess - x) < 0.001

def improve(guess: Double, x: Double) = (guess + x / guess) / 2

def sqrt(x: Double) = 
  @annotation.tailrec
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  sqrtIter(1.0, abs(x))
end sqrt

sqrt(2.0)

// // 0.001
sqrt(0.001)

// // 0.1e-20
sqrt(0.1e-20)

// // 1.0e20
sqrt(1.0e20)

// // 1.0e50
// sqrt(1.0e50)