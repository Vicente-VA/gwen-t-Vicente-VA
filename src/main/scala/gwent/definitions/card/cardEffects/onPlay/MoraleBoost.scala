package cl.uchile.dcc
package gwent.definitions.card.cardEffects.onPlay

import gwent.definitions.card.Card
import gwent.definitions.card.cardEffects.CardEffect

class MoraleBoost extends CardEffect {
  val name: String = "Morale Boost"
  val targets: (List[String], List[String]) = (List("self"), List(""))

  def apply(self: Card, target: Card): Unit = {

  }

  val targetPlayer: String = "self"
  val targetCards: String = "line"
  var applied: Boolean = false
}
