/**
 * m3-object-oriented -> 03.sc
 * */
class Employee(){
  var first: String =""
  var last: String = ""

  override def toString: String = first + " "+ last
}
val bobMartin = new Employee //bobMartin is immutable
bobMartin.first = "Bob"
bobMartin.last = "Martin"

bobMartin

bobMartin.first = "Any" // however the object member are still mutable
bobMartin.last = "Jones"

bobMartin