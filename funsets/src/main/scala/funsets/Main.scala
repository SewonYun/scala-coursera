package funsets

object Main extends App:
  import FunSets.*
  println("test start---")
  printSet(singletonSet(1))
  println(contains(singletonSet(1), 1))
  println(contains(singletonSet(2), 1))

  printSet(diff(singletonSet(1), singletonSet(1)))
  printSet(diff(singletonSet(2), singletonSet(1)))

  println("intersect")
  printSet(intersect(singletonSet(1), singletonSet(1)))
  printSet(intersect(singletonSet(2), singletonSet(1)))
  println("union")
  printSet(union(singletonSet(1), singletonSet(1)))
  printSet(union(singletonSet(2), singletonSet(1)))


  printSet(filter(singletonSet(2), (x) => x == 2))
  printSet(filter(singletonSet(2), (x) => x != 2))


  printSet(map(singletonSet(2), (x) => x))
  printSet(map(singletonSet(2), (x) => x*2))

  println(exists(singletonSet(2), (x) => x == 2))
  println(exists(singletonSet(2), (x) => x != 2))
  
  println(forall(singletonSet(2), (x) => x == 2))
  println(forall(singletonSet(2), (x) => x != 2))