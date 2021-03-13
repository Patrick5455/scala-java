
class Money(var amount:Int)

  val notMuch = new Money(50)
  println(notMuch.amount)

//invoke setter method
notMuch.amount = 100
println(notMuch.amount)



//case classes
/***
 * As Java developers, we are accustomed to the JavaBean style domain classes
 * that not include fileds with getters and setters but also constructors as well
 * as hashCOde, equals, and toString methods,
 *
 * Achieving this in Scala is very straightforward and only requires
 * the addition of the case word in front of the class declaration:
 * Examples below
 * */

case class Money(amount:Int = 1, currency:String="USD")
// assigning a values to our class members makes them default values
//if their arguments are not passed during object instantiation

/***
 * In addition to the preceding features of a traditional JavaBean style
 * domain class, they have a powerful mechanism for pattern matching (switch statements),.
 * The case word is analogous to the switch statement in Java, though it is more flexible, as we will
 * see later on.
 *
 * The case classes contain additional features aming which one is a factory method
 * to create instances (no need to use the new keyword to create one).
 *
 * By default, the fields declared in Scala classes are public, unlike Java,
 * where they have a package-private scope, defined between private and protected.
 *
 * We could have written :
 * case class Money(private val amount: Int, private val currency: String)
 * to make them private instead, or used var instead of val to make the fields mutable.
 * */

 // exploring the constructor abilities of case classed
val defaultAmount = Money()
defaultAmount //val res: Money = Money(1,USD)

val fifteenDollars = Money(15)

// if we do not specify the currency parameter, we will get a compilation error
//This is because the compiler could not guess which parameter we were referring to,
//and therefore tried to match them in order of declaration.
//To be able to use the default value for amount with the given "EUR" string,
//we need to include the parameter name explicitly
val someEuros = Money(currency =  "EUR")
someEuros // val someEuros : Money = Money(1,EUR)

val twentyEuros = Money(amount = 20, currency = "EUR")
twentyEuros // val twentyEuros : Money = Money(20, "EUR")

/****
 * An additional useful method when constructing instances is the copy method,
 * which creates a new instance out of the original and eventually replaces given parameters
 */

val aEurCopy = twentyEuros.copy(10)
aEurCopy
val aUSDCopy = twentyEuros.copy(currency = "USD")
aUSDCopy

/****
 *The copy method can be very useful when writing test fixtures, in particular,
 * when the mockup instances to be initialized have constructors with many fields
 * that are similar
 */
