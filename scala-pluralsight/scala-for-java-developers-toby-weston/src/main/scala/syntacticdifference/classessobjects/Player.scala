package syntacticdifference

import java.util.logging.Level

class Player private (forename: String, initial:String, surname: String){
// our constructor is declared private because we want our clients to be forced
  //to use the factory method apply() declared in our companion object

  val fullname = String.format("%s %s. %s", forename, initial, surname)

  // auxiliary constructor
  def this(forename: String, surname:String){
    this(forename, "",  surname)
  }


}

/***
 *You can combine objects and classes in Scala.
 * When you create a class and object with the same name and in
 * the same source file, the object is called a companion object
 */


/****
 * Usecases for companion object:
 *
 * 1. Functions Vs. Methods
 * When methods do not depend on any field of a class,
 * you can more accurately thnk of them as functions
 * Functions generally belong on a singleton object rather than a class
 *
 * 2.Factory Methods:
 * Methods that create instances of the class companion for example
 *
 *
 *
 * */


/**
 * Static: Scala does not have a static keyword but
 * members of singleton object are effectively static
 *
 * any member it contains will therefore be reused by all the clients using
 * the object, they're globally available just like static
 * */




object Player{ // companion object

  //factory method
  def apply(name: String, address: String) = new Customer(name, address)

  def main(args: Array[String]): Unit ={
     new Player("Bob", "J", "Smith")
    new Player("Bob", "Smith")
    Player.apply("Bob", "Ojunde")
  }
}

// singleton object
object Logger{
  def log(level:Level, string: String): Unit ={
    printf("%s %s%n", level, string)
  }

  def main(args: Array[String]): Unit ={
    Logger.log(Level.INFO, "Scala version")
  }
}

