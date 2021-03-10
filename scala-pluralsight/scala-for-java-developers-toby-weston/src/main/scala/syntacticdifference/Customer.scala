package syntacticdifference

class Customer (private val name: String = "Patrick",
                private val address : String ="1A Hughes Avenue, Alagomeji Yaba Lagos",
                private var id :String = ""
                //the above fields are needed when instantiating this class primary/default constructor
) {

  //fields within classes - these are not needed in the class primary constructor



  // define methods here


}

object Customer{
  def main(args:Array[String]): Unit ={ //similar to public static void main (String... args){} in java
    val eric = new Customer() //uses default parameter values as arguments
    var Jide = new Customer(name = "Jide") // named arguments
    var Ola = new Customer("Ola", "1 Ola Stret") // ordered arguemtns


    println(eric.address)
    // we can set the id of Ola also because it was declared as var (mutable)
    Ola.id = "1"
    println(Ola.id)
    //Ola.address = " " // this throws error because it was declared as val - a final variable

  }


}
