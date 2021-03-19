/**
 * CONTROL ABSTRACTIONS
 * */

def time(n:Int, operation:Int => Unit):Unit={
  val startTime = System.currentTimeMillis()
  operation(n)
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s":::::::::::: operation took $elapsedTime milliseconds")
}

val operation = (n:Int)=>{
  Thread.sleep(1000) //introduced latency
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}

time(50, operation)

//CURRIED

def time(n:Int) (operation:Int => Unit):Unit={
  val startTime = System.currentTimeMillis()
  operation(n)
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s":::::::::::: operation took $elapsedTime milliseconds")
}

val operation = (n:Int)=>{
  Thread.sleep(1000) //introduced latency
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}

//call the curried function
time(50) (operation)
// replace the parenthesis with curly braces
time(50) {operation}


//implement the function literal in curly braces
time(50){ n:Int =>
  Thread.sleep(1000) //introduced latency
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}

