package cl.uchile.dcc
package gwent.definitions.card.unit_card

import gwent.definitions.Player

trait IPlayUnit {
  def playCloseCombatCard(c: CloseCombatCard): Unit
  def playDistanceCard(c: DistanceCard): Unit
  def playSiegeCard(c: SiegeCard): Unit
}
