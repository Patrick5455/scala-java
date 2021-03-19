import scala.collection.Searching.Found

class Priority(val value:String){
  override def toString: String = value
}

class Status(val value:String){
  override def toString: String = value
}

class Task(private val value:String,
           private val priority: Priority,
           private val status: Status){

  def getValue = value
  def getPriority = priority
  def getStatus = status

  override def toString: String = s"[P: $priority][S: $status] - $value"

  }
object Task{

  def apply(value:String, priority: Priority, status: Status):Task={
    new Task(value, priority, status)
  }
}

//priorities
val high = new Priority("high")
val medium = new Priority("medium")
val low = new Priority("low")

//statuses
val todo = new Status("todo")
val inProgress = new Status("inProgress")
val done = new Status("done")

//Tasks
val t1 = Task("Finish Scala Module", high, inProgress)
val t2 = Task("Book flight tickets", high, todo)
val t3 = Task("Order wine for Friday", medium, todo)
val t4 = Task("Test Awesome Feature", medium, inProgress)
val t5 = Task("Reply to Marc", low, todo)
val t6= Task("Get s** done", high, done)
val t7 = Task("Book accommodation for talk", medium, done)

val tasks:Seq[Task] = Seq(t1, t2, t3, t4, t5, t6, t7)

def getHighPriorityTasks:Seq[Task]={
  tasks.filter(_.getPriority==high)
}

def getLowPriorityTasks = {
  tasks.filter(_.getPriority==low)
}

def getTasksInProgress = {
  tasks.filter(_.getStatus == inProgress)
}

getHighPriorityTasks foreach println
println("---------------------------")
getLowPriorityTasks foreach println
println("____________________________")
getTasksInProgress foreach println
println("______________________________")
