package cl.uchile.dcc
package gwent.definitions.card.cardEffects

import gwent.definitions.card.Card
import gwent.definitions.card.cardEffects.CardEffect

class NullEffect extends CardEffect {
  val name: String = ""
  val targets: (List[String], List[String]) = (List(), List())
  
  def apply(self: Card, target: Card): Unit = {}

  val targetPlayer: String = ""
  val targetCards: String = ""
  var applied: Boolean = true
}