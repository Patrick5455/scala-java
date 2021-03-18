/*Methods as operators*/
val i1 = 10
val i2 = 30

val sum = 11 + 12 //operator
val anotherWaySum = 11.+(12) //method

val multiply = 110 * 12
val divide = 12/11

val s = "Hello World"
s indexOf('o')
s indexOf('o', 5)

/*Prefix operators*/
val negative = -100

/*Postfix Operators*/
val toLong = 100 toLong

/*Create your own Prefix operator*/
class Text(val string: String){
  def unary_! = new Text(string + "!!")

  override def toString: String = string
}

val text = new Text("Wow")
!text // invoke prefix operator

text toString //example of postfix operator