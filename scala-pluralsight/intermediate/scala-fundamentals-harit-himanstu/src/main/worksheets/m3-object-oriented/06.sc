/**
 * m3-object-oriented -> 01.sc
 * */
class Employee(f:String, l:String, s:Int){

  private val departmentCodeByName: Map[String, String] = Map(
    "HR" -> "Human Resources",
    "ACT" -> "Accounts",
    "R&D" -> "Research and Development",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "OPS" -> "Operations",
  )


  private val first:String = f
  private val last:String = l
  private var stocks:Int = s

  //getters
  def getFirst:String= first
  def getLast:String = last
  def getStocks:Int= stocks

  def awardMoreStocks(numberOfStocks: Int) :Unit = stocks+=numberOfStocks //procedure

  def getDepartmentName(key:String) :String =
    departmentCodeByName.getOrElse(key, "The department with such code does not exist")
    //similar to the use of optional in JAVA 8 to avoid null pointers

  override def toString: String = first+" "+last+" "+stocks+" "

}
val bobMartin = new Employee("Bob", "Martin", 50)
bobMartin.getDepartmentName("R&D")
//the design of having to get a departmentName with a dependency on an instance of
//employee is not a good design.
//getDepartmentName should be a static method i.e belong to the class and
//not the object of the class

/**
 *Singleton object are object that cannot be instantiated, i.e you cannot use a
 * `new` keyword.
 * - No instantiation
 * - Just one in memory
 * - Initialized on first access
 *
 * There are 2 primary usecases of singleton objects:
 * 1. Companion objects
 * 2. Standalone Singleton objects
 *
 * Companion Objects:
 * They live in the same file of the class of the same name.
 * They are called companion because of this.
 *
 * The Companion class and the companion object
 * can see the private members of each other
 *
 * The companion object has a special method called
 * apply that can be used to create the new instance of the companion class without
 * using the new keyword. The apply method works like a `factory-constructor` method
 *
 * Standalone Singleton Objects:
 * We could create several utility functions
 * and bundle them up under one Singleton object and use them directly
 *
 * example:
 *
 * object CompanyUtils{
 *  def getOfficeLocations: Set[Location] = ???
 *  def getSocialHandles: Set[SocialHandle] = ???
 * }
 * ??? is a special keyword to tell scala that we are going to add implementation later
 * but if we call the method without adding the implementation, it throws an error
 *
 * */




