//Scala WorkSheet

/**
 *Pattern matching is analogous to switch statements in Java
 *
 * Pattern Matching in Scala:
 * pattern matching in Scala starts with the `object` you want to match,
 * followed by the keyword `natch`
 * follwoed by `curly braces` which encloses the pattern body
 * inside the body, we have various case statemtns used to match the object,
 * and the action that should be performed when matched.
 * When a match happens based on a particular case statements,
 * other cases statements are not evaluated.
 *
 * `Object match{
 *
 * case `value-to-be-matched` => `action-to-be-performed`
 * case `value-to-be-matched` => `action-to-be-performed`
 * case `value-to-be-matched` => `action-to-be-performed`
 * case _ => `action-to-be-performed`
 *
 * }`
 *
 * We can also add `guards` i.e conditioal in case statments
 * especially when they have variables. e,g
 *
 * case a (condition) => `action to-be-performed`
 *
 *
 * the `_` underscore in the default case, is a wildcard, to match all that was not matched.
 */

var amount = 150

amount match {
  case 50 => println("$50")
  case 100 => println("$100")
  case _ => println("no amount")
}

/**
 * Guards can also be used in pattern matching whne trying to assign a match to a variable
 * so we don't match all
 *
 * Notice the difference in the example below
 * */

//without guards :
//here it just matches the first one (pseudo match) and there is no precise logic to the match
amount match {
  case a => println("This is a case variable named "+a)
  case b => println("This is a case variable named "+b)
}

//with guards
//there is a real match following a precise logic as defined by the guard
amount match {
  case a$:Int if( amount != 50) => printf("case A does not match 50%n. Value is %s%n", a$.toString)
  case b$:Int if( amount == 50) => printf("case B matches  50%n. Value is %s%n", b$.toString)

}

//WE CAN ALSO ASSIGN/SAVE THE RESULT OF A PATTERN MATCH TO A VARIABLE

val amount_pattern: Unit = amount match {
  case a$:Int if( amount != 50) => printf("case A does not match 50%n. Value is %s%n", a$.toString)
  case b$:Int if( amount == 50) => printf("case B matches  50%n. Value is %s%n", b$.toString)

}

val amount_pattern_string: String = amount match {
  case a$:Int if( amount != 50) => "case A does not match 50. Value is "+a$.toString
  case b$:Int if( amount == 50) => "case B matches 50. Value is "+b$.toString
}


/***
 * Pattern Matching on Types
 */

abstract class Currency{
  //abstract class takes no immplementation

}
case class USD() extends Currency{

  //A case class in scala provides lots of benefits such as
  //1. immutable instances
  //2. easier instance cloning using copy
  //3. automatically generated equals and hashcode method among other things
}
case class  NZD() extends Currency
case class  CAD() extends Currency

val currencyA : Currency = NZD() //POLYMORPHISM
val currencyB = USD()
val amount = 100

currencyA match {
  case u: USD => println("USD "+amount)
  case c: CAD => println("CAD "+amount + (1/1.30))
  case n: NZD => println("NZD "+amount + (1/1.50))
}

/**
 * Extracting Data from pattern match
 * */

val anArray = Array(100, 200, 300)

anArray match{
  case Array(_, second, _) => print("Second Value "+second)

    // we used the a placeholder `_` for first and third index
    //because if we name they won't be used and we don't want an unused variable in order to make
    //our code elegant
}

val aTuple = ("NZD", 100)
println(aTuple)

aTuple match {
  case (currency, amount) if currency == "USD" => println("USD "+amount)
  case (currency, amount) if currency == "NZD" => println("NZD "+amount)
}
