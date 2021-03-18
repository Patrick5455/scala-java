/**
 * m3-object-oriented -> 01.sc
 * */

class Employee(f: String, l:String, s:Int){

  private val first:String = f
  private val last:String = l
  private var stocks :Int = s

  def getFirst:String = first
  def getLast:String = last
  def getStocks:Int = stocks

  def addMoreStocks(numberOfStocks:Int):Unit= stocks+=numberOfStocks

  override def toString: String = s"First Name: $first\nLast Name: $last\nStocks Owned: $stocks%"

}

//companion object
object Employee{

  val departments : Map[String, String] = Map(
    "HR" -> "Human Resource",
    "PR" -> "Public Resource",
    "OPS" -> "Operations",
    "R&D" -> "Research & Development",
    "MKT" -> "Marketing"
  )

  //singleton/static method
  def getDepartmentName(code:String):String = departments.getOrElse(code, "That code does not refer to " +
    "any department in our database")

  //factory constructor
  def apply(first:String, last:String, stock:Int) :Employee = new Employee(first, last, stock)

}

val bobMartins = Employee("Bob", "Martins", 50)
// scala implicitly calls apply method whenever we call the class name without the new keyword for object creation -> this is known as fake function calls in Scala
bobMartins //implicitly calls to string

bobMartins.addMoreStocks(20)
println("Updated Stocks for Bob Martins -> "+bobMartins.getStocks)
Employee.getDepartmentName("R&D")
