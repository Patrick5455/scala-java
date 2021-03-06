//Scala WorkSheet

/**
 *Pattern matching is analogous to switch statements in Java
 *
 * Pattern Matching in Scala:
 * pattern matching in Scala starts with the `object` you want to match,
 * followed by the keyword `natch`
 * follwoed by `curly braces` which encloses the pattern body
 * inside the body, we have various case statemtns used to match the object,
 * and the action that should be performed when matched.
 * When a match happens based on a particular case statements,
 * other cases statements are not evaluated.
 *
 * `Object match{
 *
 * case `value-to-be-matched` => `action-to-be-performed`
 * case `value-to-be-matched` => `action-to-be-performed`
 * case `value-to-be-matched` => `action-to-be-performed`
 * case _ => `action-to-be-performed`
 *
 * }`
 *
 * We can also add `guards` i.e conditioal in case statments
 * especially when they have variables. e,g
 *
 * case a (condition) => `action to-be-performed`
 *
 *
 * the `_` underscore in the default case, is a wildcard, to match all that was not matched.
 */

var amount = 50

amount match {
  case 50 => println("$50")
  case 100 => println("$100")
  case _ => println("no amount")
}
