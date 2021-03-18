/**
 * m3-object-oriented -> 01.sc
 * */
class Employee(f:String, l:String, s:Int){

  private val departmentCodeByName: Map[String, String] = Map{
    "HR" -> "Human Resources"
    "ACT" -> "Accounts"
    "R&D" -> "Research and Development"
    "MKT" -> "Marketing"
    "SLS" -> "Sales"
    "OPS" -> "Operations"

  }

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
bobMartin.getDepartmentName("HR")
