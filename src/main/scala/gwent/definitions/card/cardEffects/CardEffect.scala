package cl.uchile.dcc
package gwent.definitions.card.cardEffects

import gwent.definitions.card.Card

trait CardEffect {
  val compatibleCards: List[]
  def apply(self: Card, other: Card): Unit
}