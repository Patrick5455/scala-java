/***
 * Rich Interfaces and Stackable Modifications
 * */

case class Event(id:Int,
                 location:String,
                 dayOfWeek:String,
                 sessionTimeInSeconds:Integer,
                 source:String)

val e1 = Event(1, "US", "Sun", 10, "Twitter")
val e2 = Event(2, "China", "Mon", 15, "weChat")
val e3 = Event(3, "New Zealand", "Sun", 30, "Twitter")


/*Thin Interface*/
trait EventsInterface{
  def get(eventId:Int):Option[Event]
  def all: List[Event]
}

class Events(val events:List[Event]) extends EventsInterface{

  override def get(eventId: Int) = events.find(_.id == eventId)

  override def all = events
}

val events:Events = new Events(List(e1, e2, e3))

events.get(1)
events.all
