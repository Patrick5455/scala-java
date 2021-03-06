import scala.:+
//Scala WorkSheet

/**
 * FUNCTIONS, METHODS, AND IMPLICIT CONVERSIONS
 * */

/**
 * Functions are code abstractions that you can place in Scala files
 * You can also place them in Scala class boundary.
 * When they are directly placed in a file. THey are known as functions.
 * When they are accessed from a class, they are known as methods
 *
 * Functions starts with the `def` keyword followed by the functionName
 *
 * def functionName(argument : Type): ReturnType = {body}
 * */


def square(x:Int) : Int = { // method declaration
  x * x
}

val sq_2 = square(2) //method call

def multiply(x: Int, y:Int) = x * y

// overloaded function to take variable arguments for multiply

def multiply(nums:Int*) ={

  var product = 1
  for (num <- nums) product = product * num
  product
}
val sq_many  = multiply(5, 6, 7, 8)

/**
 *Functions inside a function - Local Functions
 * If you think your function require other functions and are not to be shared outside,
 * consider creating local functions to write cleaner codes
 * */

def sumOdds(num :Int = 5) : Int ={
  //use a local function to collect odd numbers within the rage of num
  var odds = Array[Int]()

  def getOdds(value : Int): Array[Int] = {
    var  current = 1
    while (current <= value){
      if (current%2 !=0) odds =odds:+current // array insertion
      current = current+1
    }
    printf("Odd Numbers in range of %d are [%s]%n", value, odds.mkString(","))
    odds //return array of odd values
  }
  getOdds(num) //call local function in main function scope
  printf("Sum of odd numbers: %d%n", odds.sum)
  odds.sum //return sum of odd values
}

sumOdds(10)

/**
 * Named Functions/Default Values
 * */

def logTransactions(amount : Double,
                    debit:Boolean = true,
                    currency: String = "USD"): Unit ={
  // we are not returning anything so we assign a type of Uint as function return type

  printf("Transaction is %s%.2f%s", if (debit) "-" else "+", amount, currency)
}
//we can decide not to pass in arguments for the named parameters with default values, so the default values are used in place
logTransactions(amount = 500)
logTransactions(debit = false, amount = 500)
logTransactions(debit = false, amount = 600, currency = "NZD")

/**High Order Functions
 *
 * An high order function is a function that either takes another
 * function as the input or returns another function as the return values
 *
 * A map function in scala is an high order function becuase it used to
 * transform a value from type a to type b e.g string to Int
 *
 * map takes a function
 *
 * see examples below
 * */
//FUNCTION                    FUNCTION TYPE
def square (n:Int) : Int = n*n //Int => Int
def cube (n:Int):Int = n + n + n //INt => Int
def sum(a:Int, b:Int) : Int = a + b //(Int, Int) => Int
def length(a: String) : Int = a.length //String => Int

//declare an high order function that we can pass the short
//functions declared above as arguments to

def transform(f: Int => Int, numbers:Int*): Seq[Int] = numbers.map(f) // we don't need a curly brace since it is a single line in the body

//square and cube functions matches the argument type of the (high order) transform function

transform(cube, 5,6) // this takes each of the number in the numbers argument and applies the function cube to them and saves the result as a sequence of int
transform(square, 1, 2,3,4,5)

// we can also pass a function with its actual implementation in an high order function e,g
//this is known as function literal or anonymous function becuase you can't call the function with a reference elsewhere
transform((n: Int)=> n*n, 5,6,7) // this does the same thing as the square method
transform((n: Int)=> 2*n*3, 5,6,7)

//just like functional interfaces and collections,
//there are various high order functions that works with collections in Scala
//see examples below

val numbers = Array(1, 2,3,4)
numbers.map(num => num*2)
numbers.filter(num => num%2 ==0) //OR
numbers.filter(_%2 ==0)
//filter takes a function that takes a number and returns a boolean
