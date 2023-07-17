package cl.uchile.dcc
package gwent.definitions.card.cardEffects

import gwent.definitions.card.Card

import scala.reflect.ClassTag

/** CardEffect modela los efectos que pueden tener las cartas
 * 
 * - targetPlayer: self, opponent, all
 * 
 * - targetCards: row, section, closeCombat, distance, siege
 */
trait CardEffect {
  val name: String
  val targetPlayer: String
  val targetCards: String
  var applied: Boolean

  def apply(self: Card, target: Card): Unit
}