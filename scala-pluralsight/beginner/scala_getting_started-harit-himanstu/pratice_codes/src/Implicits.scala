
case class Currency(code: String, amount: Double, toUSD:Double)

object Implicits extends App {


 implicit def stringToCurrency(money: String): Currency ={
    //money "USD 556"
    val Array(code:String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble

    code match {
      case "USD" => Currency("USD", amountAsDouble, amountAsDouble)
      case "NZD" => Currency("USD", amountAsDouble, amountAsDouble *(1/1.5))
      case "CAD" => Currency("USD", amountAsDouble, amountAsDouble *(1/1.30))
    }
}
  println(stringToCurrency("USD 100"))
  println(stringToCurrency("NZD 250"))

  val cad : Currency = "CAD 100" //implicitly mapped to type currency
  //using the implicit method  stringToCurrency
  println(cad)
}
