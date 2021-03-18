package syntacticdifference.inheritance

class Customer (name: String, address: String){

  // items: Array[Item]

  def total() = 0.00

  def add(item: Item):Double = {
    item.price()
  }



}
