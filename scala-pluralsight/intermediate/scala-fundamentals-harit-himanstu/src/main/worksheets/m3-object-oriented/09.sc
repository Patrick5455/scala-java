/**
 * Immutability Benefits:
 * - Easy to reason
 * - Share freely
 * - Concurrent safety
 * - Safe hash keys
 */

class Employee(f:String, l:String, s:Int){

  private val firstName = f
  private val lastName = l
  private val stocks = s

  def getFirstName = firstName
  def getLastName = lastName
  def getStocks = stocks

  override def toString: String = s"Employee Bio Data:\nFirst Name: $firstName\nLast Name: $lastName\nStocks Owned: $stocks%"

  def updateStocks(numberOfStocks:Int):Employee = {
    val updatedStocks = this.stocks+numberOfStocks
    Employee(this.getFirstName, this.getLastName, updatedStocks) //implicitly calls apply method (factory constructor)
  }

}

object Employee{

  private val departmentDir :Map[String, String] = Map(
    "R&D" -> "Research & Development",
    "OPS" -> "Operations",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "FIN" -> "Finance"
  )

  def getDepartmentName(code:String) :String= departmentDir.getOrElse(code, "No department matches that code")

  def apply(firstName:String, lastName:String, stocks:Int) :Employee = new Employee(firstName, lastName, stocks)
}

val patrickOjunde = Employee("Patrick", "Ojunde", 51)

val patrickOj= patrickOjunde.updateStocks(20)

Employee.getDepartmentName("OPS")