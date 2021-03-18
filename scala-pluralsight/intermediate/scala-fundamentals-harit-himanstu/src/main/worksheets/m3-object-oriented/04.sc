/**
 * m3-object-oriented -> 04.sc
 * */
class Employee(val first: String, val last:String){
  override def toString:String = first +" "+last
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin

/**
 * NB: Constructor fields are different from class member fields.
 * Class members fields (inside curly braces) when declared,
 * must be assigned a value or else the compiler will throw an error
 *
 * The constructor fields on the other hand (inside the paranthesis)
 * are used for construction of class objects or object instantiation.
 * Also, by default they are not visible (i.e they are private unlike the class member fields which
 * are public by default), i.e
 * we cannot do something like this with them `object.field = value`
 * or else the compiler throws an error.
 *
 * To make them visible, we have to add either a val or var to them.
 * val or var deals with mutability.
 * Doing this implicitly makes the constructor fields access modifier `public` from the default
 * `private` mode
 *
 * Now after adding either of val or var, we the constructor fields are now visible,
 * but mutability is dependent on the type (i.e var or val)
 * */

bobMartin.last
bobMartin.first

class Color(val value:String) //public val field
val c = new Color("RED")
c.value

class Shape(var value:String) //public var field
val s = new Shape("CIRCLE")
s.value
s.value = "SQUARE"
s.value
