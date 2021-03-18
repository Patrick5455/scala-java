/** LOCAL FUNCTIONS
 * Local functions are functions which are nested inside the function
 *Only in the scope of Parent function
 *
 * Local functions are nested inside a function
 * Parameter access of a Parent function
 * Not visible outside of a Parent function
 * */

class Calculator{

  def sumOfSquares(a:Int, b:Int)={
    def square(n:Int) = Math.pow(n, 2).intValue()
    square(a) + square(b)
  }

  def multiplyDoubles(a:Int, b:Int)={
    def double(n:Int) = 2*n
    double(a) * double(b)
  }

  def divisionOfCubes(a:Int, b:Int)={
    def cube(n:Int) = Math.pow(n, 3).intValue()
    cube(a) / cube(b)
  }
}

val calc = new Calculator
calc.sumOfSquares(2, 3)
calc.multiplyDoubles(3, 2)
calc.divisionOfCubes(5, 2)


