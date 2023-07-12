package cl.uchile.dcc
package gwent.definitions.card.cardEffects.onPlay

import gwent.definitions.card.Card
import gwent.definitions.card.cardEffects.CardEffect

class MoraleBoost(self: Card) extends CardEffect {
  val name: String = "Morale Boost"
  val targets: (List[String], List[String]) = (List("self"), List(""))

  def apply(self: Card, target: Card): Unit = ???
}
