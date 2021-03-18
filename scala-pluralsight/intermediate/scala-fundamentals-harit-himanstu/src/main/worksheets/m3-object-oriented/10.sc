/**
 * m3-object-oriented -> 10.sc
 * */

/**
 * INHERITANCE:
 *
 * An abstract class is s class that starts with the abstract
 * keyword.
 * The class has members which only contains declaration and
 * may not have definition
 *
 * The declaration is the left hand side of the equals sign,
 * while the definition is the right hand side of the equals sign
 *
 * Members who do not have definitions are known as abstract members
 *
 * The first concrete class that inherits an abstract class, must
 * define the values/implementations of abstract members
 * */

abstract class Employee{

  val first:String //abstract members
  val last:String //abstract members

}

abstract class DepartmentEmployee extends Employee{
  private val secret = "Big Secret"
  val department :String
  val departmentCode:String
  val numberOfStocks:Int

  override def toString: String =
    s"[$first, $last, $department, $numberOfStocks]"
}

class RnDEmployee(f:String, l:String) extends DepartmentEmployee{

  override val department = "Research and Development"
  override val departmentCode = "R&D"
  override val numberOfStocks = 100
  override val first = f
  override val last = l
}

class MarketEmployee(f: String, l:String) extends DepartmentEmployee{

  override val department = "Marketing"
  override val departmentCode = "MKT"
  override val numberOfStocks = 85
  override val first = f
  override val last = l
}

val rnDEmployee = new RnDEmployee("Patrick", "Ojunde")
val marketEmployee = new MarketEmployee("Odole", "Letus")


/**
 * COMPOSITION:
 *
 * */

abstract class Company{
  val name:String
  val numberOfEmployees:Int
  val employees: Set[Employee]

  override def toString: String = s"[Company Name: $name, No of employees: $numberOfEmployees]"
}

class PluralSight(n:String, es:Set[Employee]) extends Company{
  override val name = n
  override val numberOfEmployees = es.size
  override val employees = es
}

val pluralSight = new PluralSight("PluralSight Inc",
  Set(rnDEmployee, marketEmployee))
printf("PluralSight No of Employees: %d%n", pluralSight.numberOfEmployees)
