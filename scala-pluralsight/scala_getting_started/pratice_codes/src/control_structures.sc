//Scala WorkSheet
/***
 * Expression Vs. Statements:
 *
 * The programme that we write are categorised into expressions or statments.
 *
 * An expression is something that yields a value
 * e.g ana arithemtic expression (1 +1, 2*2) or an arithmetic function  like
 * getSquare(num) is also an expression since it yeidls a value
 *
 * A statement is a line of code that does something such as ordring a pizza function.
 * While expression does not contain side effect, statments contains side effect.
 *
 * Exaples of statments include printing to the console, writing to a file, etc.
 *
 *
 */

/**
 * If Conditions
 *
 */
val number = 100
if(number > 10){
  println("> 10")
} else {
  println("<= 10")
}

// we can also assign a condition to a variable
val symbol: Unit = if(number > 10) println("> 10") else println("<= 10")

val new_symbol :String= if(number > 10) "> 10" else "<= 10"
// in the above we are returning a type of string. Scala "returns" work in this way,
//return does not need to be sepcified, the last value in a function/statement
//serve as the return vale.

val symbol_3: Unit = if(number > 10){
  println("> 10")
} else if (number == 10) {
  println("== 10")
}
else {
  println("< 10")
}

/**
 * For Loop:
 * Used to repeat certain action/tasks multiple times
 * the expression in the for loop bracket is known as a `generator`
 *
 */

val greetings = Array("Hello", "World")
val loop_guy: Unit = for(greet <- greetings){
  println(greet)
}
println(loop_guy) // print the type definition of loop_guy

//we can use the yield keyword to make a loop an expression, that returns
//all the values mapped/unmapped in the loop definition

val yielded_guys = for(greet <- greetings) yield  greet //NB: the result (yielded values) is of type array and not string because it colects all the yielded values into an array
//we can confirm that by printing the assigned variable type definition
println(yielded_guys.mkString("Array(", ", ", ")"))

//in for loops, you can have more than one collections.
//This means you can have a for loop with two generators
// OBSERVE THE SYNTACTIC DIFFERENCE IN FOR LOOPS WITH MULTIPLE COLLECTIONS

var amounts = Array(30, 40, 50)
val currencies = Array("USD", "CAD")

val levels = for{
  amt <- amounts
  curr <- currencies
} yield curr + " "+amt // we can also surround the expression of yield with a urly braces e.g
// yield { curr + " "+amt}

/**
 * in addition to adding generators in for loops,
 * we can also add conditionals.
 * These usage of conditions is known as guards.
 * The purpose is to act as a filter.
 *example below
  */

amounts = Array(10, 24, 50, 60 , 18, 35, 29, 20)
val guards = for{
  amount <- amounts
  currency <- currencies
  if(amount> 20 && amount < 30) && (currency == "USD")
} yield {
  currency +" "+amount
}

/**
 * For Each:
 * For each is available as a method on collections such as array.
 * Foreach does not yield a value, which makes it a statement.
 * For each is an high order function
 * example shown below
*/

amounts.foreach( amount => println(amount *1000))
List(1,2,3,4).foreach(num => println(num * 20))
