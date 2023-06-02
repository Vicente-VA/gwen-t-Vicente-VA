package cl.uchile.dcc
package gwent.definitions.card.unit_card

import gwent.definitions.Player

trait IPlayUnit {
  def playCloseCombatCard(c: CloseCombatCard): Boolean
  def playDistanceCard(c: DistanceCard): Boolean
  def playSiegeCard(c: SiegeCard): Boolean
}
