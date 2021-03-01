package classes

object Main extends App {
  val john = new Employee

  john.setSalary(100)
  val johnSalary = john.getSalary()

  println(johnSalary)
}
