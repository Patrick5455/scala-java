import scala.::
import scala.collection.immutable.Nil

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


//FUNCTIONS AND METHODS
/****
 * In Scala, we use the `def` keyword to define a class-method or a function,
 *
 */

case class Money( amount :Int=1, currency:String="USD") {

  def +(other: Money): Money = {
    Money(amount + other.amount) // return keyword is implicit because the last line code is of the return type specified
  }

  /** *
   * Notice that we can use + as a method name.
   * We have also included the return type `Money` in the signature declaration,
   * which is only optional since the type inference of Scala will deduct it,
   * but including it explicitly is a good documentation pratice for
   * public methods (and methods are public by default if no other scope is specified).
   *
   * Moreover, in Scala, the return word at the end of the method is optional,
   * the last statement is always the one that is returned to the caller of the method,
   *
   * Furthermore, it is generally considered a good practice to omit the return keyword since it is not mandatory.
   * */
}


//calling the method
val balance = Money(12) + Money(34)
println(balance.toString)


//Collection
val odds : List[Int] = List(1,3,5)
val evens = List(2,4,6)

odds
evens

/***
 * Scala collections systematically distinguish between immutable and mutable collections,
 * but encourage immutability by constructing immutable collections by default.
 *
 * They simulate additions, updates or removal by returning
 * new collections from such operations instead of modifying them.
 *
 * One way to print out the numbers is that we can follow java's imperative style of
 * programming and iterate over the collection by creating a for loop:
 * */

for(n <- odds) println("Odd number "+n) //similar to forEach lambda call in Java

/***
 * Another way to write the code in Scala (as well as many other languages on the JVM,
 * such as Groovy, JRuby, or Jython) involves a more functional style, using lambda
 * expressions (sometimes referred to as closures).
 * In brief, lambdas are just functions that you can pass around as parameters.
 * These functions take input parameters (in our case, the n integer) and return
 * the last statement/line of the body.
 *
 * They are in the following form;
 *
 * functionName(input =>
 *              body
 *              )
 *
 * A typical example of lambda to iterate over the elements of the bnumbers
 * list we have defined earlier is given as follows:
 * */

evens.foreach(num => println("even number "+num))

/***
 * Scala collections are, by default immutable. This is a very important aspect for
 * making them behave as expected when dealing with multiprocessor architectures.
 * */

  //OPERATIONS ON COLLECTIONS
val numbers = List(1,2,3,4,5,6)
numbers
val reversedList = numbers.reverse
reversedList
val onlyAFew = numbers drop 2 take 3
onlyAFew

/***
 * The drop method indicates that we get rid of the first two elements
 * of the list, and the take indicates that we keep only three elements
 * from the result obtained after the drop method.
 *
 * The drop and take function is one of the many syntactic sugars that were added to Scala
 * */

/***
 * Another way of writing elements in a given list
 * is by using the :: method, generally referred to in
 * Scala documentation as the "cons operator".
 *
 * This alternative syntax looks like the following expression
 * */

val numbers = 1 :: 2 :: 3 :: Nil

/***
 * THe Nil values:
 * There is a simple rule in Scala that says that a method whose
 * last character is a `:` (that is a colon) is applied on its
 * right side rather than the left side
 * (such a method is called a right-associative).
 *
 * So, the evaluation of 6 :: Nil is not equivalent to 6.::(Nil) in that case,
 * but rather Nil.::(6).
 *
 * Example below
 * */

val simpleList = Nil.::(6)
simpleList //simpleList: List[Int] = List(6)

/***
The evaluation of 5 :: 6 :: Nil is therefore done by applying the
 :: method on the simpleList that we saw earlier, which  is List(6):
 */

val twoElementsList = List(6).::(5)
twoElementsList

/****
 * In this case, 5 was appended before 6.
 * Repeating this operation severla times will give you the final
 * List(1,2,3,4,5,6).
 *
 * This convenient way of expressing lists is not just
 * for simple values such as integers but can be applied to any type.
 *
 * Moreover, we cna concatenate two List instances by using the ::: method in a similar way
 */

val concatenatedList = simpleList ::: twoElementsList
concatenatedList

/***
 * A List is heterogeneous
 * */

val things = List(0,1,true)
things // List(AnyVal) = List(0,1,true)


//COLLECTIONS OF MORE COMPLEX OBJECTS
val walletA = twentyEuros :: fifteenDollars :: aUSDCopy :: Nil

walletA
val walletB = List(Money(10), Money(2, "EUR"),
  Money(20, "GBP"))
walletB

//some List methods
val firstMoneyInWalletA = walletA.head
firstMoneyInWalletA

val otherMoneyInWalletA = walletA.tail
otherMoneyInWalletA

/***
 * FILTER AND PARTITION
 *
 * Filtering elements of a collection is one of the most commons
 *
 * example:
 */

val euroWallet = walletA.filter(_.currency == "EUR")
euroWallet
val usdWallet = walletB.filter(money => money.currency == "USD")
usdWallet

/***
 * The parameter given to the filter method is a function
 * that takes a Money item as the input and returns a Boolean value (that is, a predicate),
 * which is the result of evaluating money.currency=="EUR".
 *
 * The filter method iterates over the collection items and applies the function to
 * each element, keeping only the elements for which the function returns `True`.
 *
 * Lambda expressions are also referred to as `anonymous functions` because we could give
 * any name we want to the input argument, for example, x instead of the `money` used previously,
 * and still get the same output:
 * */

val goodWallet = walletA.filter(x => x.amount>100)
goodWallet


/***
 * A filterNot method also exists to keep elements for which evaluation of the function
 * returns `False`.
 *
 * Moreover, a partition method is available to combine both
 * the `filter` and `filterNot` methods into one single call that returns two collections,
 * one evaluating to True and the other to its complement, as shown in the following code snippet
 * */

val allAmounts = walletA.partition(amt => amt.currency=="EUR")
allAmounts // contains two lists
allAmounts._1 //result form True -> val res27: List[Money] = List(Money(20,EUR))
allAmounts._2 // result from False -> val res28: List[Money] = List(Money(15,USD), Money(20,USD))

//DEALING WITH TUPLES
/***
 *Notice the return type of the partition result,
 * (List[Money], List[Money]).
 * Scala supports the concept of tuples. The preceeding parenthesis notation denotes
 * a Tuple type, which is a part of the standard Scala library and useful to manipulate several elements at once
 * without having to create a more complex type for encapsulating them.
 * In our case, allAmounts is a Tuple2 pair containing two lists of Money.
 * To access only one of the two collections, we just need to type the following expressions:
 * */

val euros = allAmounts._1
euros //euros: List[Money] = List(Money(2,EUR),Money(75,EUR))
val everythingButEuros = allAmounts._2
everythingButEuros // everythingButEuros: List[Money] = List(Money(10,USD),Money(20,GBP),Money(
//100,USD),Money(50,USD))
/***
 * A cleaner and more neutral syntax to achieve this is a one-liner, is the one that
 * expresses the partition method without referrring to ._1 and ._2, as shown in the
 * following code snippet:
 * */

val (eurosWallet, nonEurosWallet) = walletA.partition(amt => amt.currency == "EUR")
eurosWallet
nonEurosWallet

//MAP
/***
 * Another elegant usage of tuples is related to the definition of a Map collection,
 * another structure that is part of the Scala collections. Similar to Java, the Map collection
 * stores key-value pairs.
 *
 * Populating a Map collection in Scala can be elegantly written as follows:
 * */

val wallet = Map("EUR" -> 10, "GBP" -> 20)
wallet
/***
 * The "USD" -> 10 expressino is a convenient way of specifying a
 * key-value pair and is equivalent to the definition of a
 * Tuple2[String, Integer] object in this case, as illustrated directly
 * in the REPL(which could infer the type automatically):
 *
 * */
val tenDollars = "USD" -> 10
tenDollars
val tenDollars = ("USD", 10)
tenDollars

/***
 * The process of adding and retrieving an element is very straightforward:
 * */

val updatedWallet = wallet + ("GBP" -> 20) //inserting an element into a map
updatedWallet

val someEuros = wallet("EUR")
someEuros






