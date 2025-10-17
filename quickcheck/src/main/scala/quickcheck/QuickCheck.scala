package quickcheck

import org.scalacheck.*
import Arbitrary.*
import Gen.*
import Prop.forAll

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap:
  lazy val genHeap: Gen[H] = oneOf(
    const(empty),
    for {
      v <- arbitrary[Int]
      h <- oneOf(const(empty), genHeap)
    } yield insert(v, h)
  )
  
  given Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if isEmpty(h) then 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("min1") = forAll { (a: Int) =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("min2") = forAll { (a: Int, b: Int) =>
    val h = insert(b, insert(a, empty))
    findMin(h) == Math.min(a, b)
  }

  property("deleteMin1") = forAll { (a: Int) =>
    val h = insert(a, empty)
    isEmpty(deleteMin(h))
  }

  property("sorted") = forAll { (h: H) =>
    def isSorted(h: H): Boolean =
      if isEmpty(h) then true
      else
        val m = findMin(h)
        val h2 = deleteMin(h)
        isEmpty(h2) || (m <= findMin(h2) && isSorted(h2))
    isSorted(h)
  }

  property("meld1") = forAll { (h1: H, h2: H) =>
    val m = meld(h1, h2)
    if isEmpty(h1) && isEmpty(h2) then isEmpty(m)
    else if isEmpty(h1) then findMin(m) == findMin(h2)
    else if isEmpty(h2) then findMin(m) == findMin(h1)
    else findMin(m) == Math.min(findMin(h1), findMin(h2))
  }

  property("deleteMin2") = forAll { (a: Int, b: Int) =>
    val h = insert(b, insert(a, empty))
    val h2 = deleteMin(h)
    findMin(h2) == Math.max(a, b)
  }

  property("meld2") = forAll { (h1: H, h2: H) =>
    def toList(h: H): List[Int] =
      if isEmpty(h) then Nil
      else findMin(h) :: toList(deleteMin(h))
    val m = meld(h1, h2)
    toList(m) == (toList(h1) ++ toList(h2)).sorted
  }

