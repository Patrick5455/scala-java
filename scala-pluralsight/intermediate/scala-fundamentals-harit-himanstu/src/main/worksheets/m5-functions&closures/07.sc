/**
 * APPLYING REPEATED ARGUMENTS TO FUNCTIONS
 * */

def lengthOfStrings(strings: Seq[String]):Unit =
  strings foreach(s => println(s"$s -> ${s.length}"))
lengthOfStrings(Seq("a", "bb", "ccc"))

/*with repeated parameters*/
def lengthOfStringsR(strings: String*): Unit=
  strings foreach(s => println(s"$s -> ${s.length}"))
lengthOfStringsR("a", "bb", "ccc")

/* repeated parameters but caller has array*/
def incrementBy1(numbers: Int*) = numbers map(_+1)

val arr = Array(1,2,3,4,5)
//incrementBy1(arr) //compilation failure
incrementBy1(arr:_*)
incrementBy1(1,2,3,4,5)
