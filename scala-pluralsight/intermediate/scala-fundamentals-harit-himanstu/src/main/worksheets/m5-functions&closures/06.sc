/**
 * CLOSURES:
 * This form of function literal where the compiler captures the binding
 * of free variables is known as `closures``
 *
 * It is called this way because the act of closing the function literal by capturing
 *the bindings of its free variables.
 *
 *
 *
 * free and bound variable.*/

  /*if y is known, the compilation works*/
var y:Int = 99 // free variable
val sum = (x:Int) => x+y  // this is a closure
//x is bound variable

sum(5)

/*case 1: free variable changes after function value is created*/
var case1free = 20
val case1sum = (x:Int) => x+case1free

case1sum(80)

case1free = 10
case1sum(80)

/*case 2: function value changes the value for free variable*/
var case25sum =0

val calculateSum = (numbers:Seq[Int]) => numbers.foreach(case25sum +=_)
calculateSum(Seq(1,2,3,4,5,6,7,8,9,10))

case25sum

/*case 3: the free variable is a local variable of a function*/
def multiplier(factor:Int) = (x:Int) => x * factor
//NB: multiplier returns a closure

val double = multiplier(2) //free variable
val triple = multiplier(3) //free variable

double(2) //bound variable
triple(2) //bound variable
