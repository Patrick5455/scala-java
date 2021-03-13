package syntacticdifference.inheritance

class DiscountedCustomer (name: String, address: String)
  extends Customer (name = name, address = address) //similiar to super
 {

   override def total():Double={
     super.total *0.90
   }



}
