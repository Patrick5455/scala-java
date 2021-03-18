/**
 * m3-object-oriented -> 04.sc
 * */
class Employee(first: String, last:String){
  override def toString:String = first +" "+last
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin

/**
 * NB: Constructor fields are different from class member fields.
 * Class members fields (inside curly braces) when declared,
 * must be assigned a value or else the compiler will throw an error
 *
 * The constructor fields on the other hand (inside the pararnthesis)
 * are used for construction of class objects or object instantiation.
 * Also they are not visible (like the class member fields), i.e
 * we cannnt do something like this with them `object.field = value`
 * or else the compiler throws an error
 *
 *
 * */
