/**In Scala, functions are treated as first class citizens.
* This means that we can not only define or call them.
* We can also write them as literal, and pass them around as values
 */


def transform(numbers: Seq[Int], f:Int=>Int) =
  numbers.map(num => f(num))

val someNumbers = Seq(0,1,2,3,4,5,6)

val numbersIncrementedBy1 = transform(someNumbers, (x:Int)=>x+1)

val numbersSquared = transform(someNumbers, x => math.pow(x, 2).intValue())

val numbersMultipliedBy2A = transform(someNumbers, x => x*2)

val numbersMultipliedBy2B = transform(someNumbers, 2*_)



