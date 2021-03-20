import java.util.UUID

/**
 * TRAITS:
 * Unlike classes, traits do not accept class parameters and cannot be instantiated.
 * They are like "interfaces" in java
 *
 * They are declared with the word trait
 * */

trait DB{
  private var contents: Map[String, String] = Map.empty
  protected def save(key:String, value:String)= contents+=(key -> value)
  def get(key:String) = contents.get(key)
}

class Bank extends DB {
  def openAccount(userId:String) ={
    val accountId = "A-"+UUID.randomUUID()
    save(userId, accountId)
    accountId
  }

  def getAccount(userId: String) = get(userId)
}

val bank = new Bank
val bobUserId = "U-BOB-"+ UUID.randomUUID()
val amyUserId = "U-AMY-"+UUID.randomUUID()

val bobAccountId = bank.openAccount(bobUserId)
val amyAccountId = bank.openAccount(amyUserId)

assert(bobAccountId == bank.getAccount(bobUserId).get, "Bob Account Id do not match")
assert(amyAccountId == bank.getAccount(amyUserId).get, "Amy Account Id do not match")
