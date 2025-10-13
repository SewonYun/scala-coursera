package recfun

import scala.compiletime.ops.any
import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =

    // * Exercise 1
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

    // * Exercise 2
    val balanceResult: Boolean = balance(")((())()".toList)
    println("balanceResult - -")
    println(balanceResult)

    // * Exercise 3
    val countConins: Int  = countChange(5, List(1, 2, 3))
    println(countConins)

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    
    if(c == r || c == 0) 
      return 1
    
    pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    if(chars.isEmpty) {
      return true
    }
    
    def innerFun(head: Char, tails: List[Char], leftCount: Int, rightCount: Int): Boolean = {
      if(leftCount < rightCount) return false

      if(tails.isEmpty) {
        val lastRightCount: Int = {
          if(head == ')') rightCount + 1
          else rightCount
        }
        if (head == '(' || leftCount != lastRightCount) return false
        else return true
      }

      if( head != '(' && head != ')') {
        return innerFun(tails.head, tails.tail, leftCount, rightCount)
      }

      if(head == '(') {
        return innerFun(tails.head, tails.tail, leftCount + 1, rightCount)
      }

      if(head == ')') {
        return innerFun(tails.head, tails.tail, leftCount, rightCount + 1)
      }
      
      throw new Error("no filtered condition")
    }

    innerFun(chars.head, chars.tail, 0, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0)
      1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
