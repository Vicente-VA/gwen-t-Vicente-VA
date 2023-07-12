package cl.uchile.dcc
package gwent.definitions.card.cardEffects

import gwent.definitions.card.Card

import scala.reflect.ClassTag

trait CardEffect {
  val name: String
  val targetPlayer: String
  val targetCards: String

  def apply(self: Card, target: Card): Unit
}

// this, next, opposite, other
// line, section, closeCombat, distance, siege