import scala.annotation.tailrec

/**
 * RECURSION SCALA
 */

val n =5

def sumR(n:Int):Int ={
  if(n==1) 1
  else n + sumR(n-1)
}

sumR(n)

def sumTR(n:Int):Int ={
  @tailrec
  /**
   * Tail Recursion is a technique where the calculations are completed first
   * before passing in the results to the next recursive call.
   * That way, since there are no more calculations left on the current stack,
   * it can go away as soon as soon as the next call is made.
   *
   * This way, there will be no more than one stack running to compute the solution
   * */
  def go(currentNum: Int, totalSoFar:Int =0):Int ={
    if(currentNum == 0) totalSoFar
    else go(currentNum -1, totalSoFar + currentNum)
  }
  go(n)
}
sumTR(n)

