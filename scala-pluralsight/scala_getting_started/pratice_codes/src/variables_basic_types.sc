// Scala Worksheet

var number_a : Int = 100
var number_b = 200 //implicit reference

var char_escape = "Hello \"Patrick Ojunde\"" //scala escape character

/**
 *Scala TYpe System:
 * Broad 2 major scala types :
 * 1. AnyVal : scala primitive types (9) inherits from (analogus to java primitive types)
 * 2. AnyRef : any objects that inherits from java.lang.Object e.g Strings, CLass, Arrays, Maps, etc.
 *
 * - Null is a subtype that inherits from AnyRef
 * - Option is a subtype that inherits from ANyRef
 *- Nothing is like the null equivalent for AnyVal
 * - A special use of the nothing type is to use it as a return type when the omputation does not happen normally.
 * nothing type is been used by methods such as exit and error
 *
 * AnyVal is divided into numeric and non-numeric types, and Boolean
**/

//primitive types - AnyVal
var dos : AnyVal = 3
var sod : AnyVal = 1

//Reference Types - AnyRef
var Arr : AnyRef = Array(1, 2, 3)
var Arr : AnyRef = Array("Hello", "World")

var index1: AnyVal = Arr(0)
println(index1)


//Value Type Casting
/**
 * Casting maintains the order of the primitive types.
 * I.e a primitive type can only be casted to another higher than itself not lower to itself. e.g flot to double
 */

//Working with
/**
 *Scala leverages JVM for date-time operations.
 * SO we import java.util.time package to work with date and time in Scala
 * - We can use LocalDate, LocalTime, and LocalDateTime, and ZonedTime Classes in Scala
 */
