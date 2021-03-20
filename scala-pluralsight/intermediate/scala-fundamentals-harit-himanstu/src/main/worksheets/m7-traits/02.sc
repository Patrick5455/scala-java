/** Using Traits as Type**/
trait DB{
  private var contents: Map[String, String] = Map.empty
  def save(key:String, value:String):Unit = contents+={key -> value}
  def get(key:String) = contents.get(key)
}

class InMemoryDB extends DB

val repo: DB = new InMemoryDB

repo.save("a", "apple")
repo.save("b", "banana")

repo.get("a")
