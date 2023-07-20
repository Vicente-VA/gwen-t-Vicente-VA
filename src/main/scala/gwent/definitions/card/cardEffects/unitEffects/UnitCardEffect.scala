package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.CardEffect

/** UnitCardEffect modela los efectos que pueden tener las cartas de unidad
 * 
 * - targetPlayer: self, opponent, all
 * 
 * - targetCards: row, section, closeCombat, distance, siege
 */
trait UnitCardEffect extends CardEffect{
  def apply(self: UnitCard, target: UnitCard): Unit
}