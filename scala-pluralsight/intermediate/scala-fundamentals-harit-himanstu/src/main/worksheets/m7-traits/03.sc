/** Extending classes and using Traits ->
 * Using keyword with to add Traits is the idea of mixin*/

trait DB{
  private var contents:Map[String, String] = Map.empty

  def save(key:String, value:String) ={contents+={key->value}}
  def get(key:String) ={contents.get(key)}
}

class Human

class Employee extends Human with DB

val employees: DB = new Employee

employees.save("e1", "Patrick Ojunde")
employees.save("e2", "Ebot Tabi")

employees.get("e1")

/** Trait Mix-ins
 * when extending class
 * class MyClass extends OtherClass with Trait1 with Trait2 with Trait3
 *
 * class MyClass extends Trait1 with Trait2 with Trait3
  */