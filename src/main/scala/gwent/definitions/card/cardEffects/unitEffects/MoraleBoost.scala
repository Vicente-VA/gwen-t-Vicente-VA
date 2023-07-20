package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

/**
 * Morale Boost (Refuerzo moral)
 * 
 * Aumenta en un punto la fuerza de todas las cartas en la fila de quien aplica, menos a ella misma
 */
class MoraleBoost extends atSelfRow {
  override val name: String = "Morale Boost"

  def apply(self: UnitCard, target: UnitCard): Unit = {
    target.setBaseStrength(target.getStrength + 1)
  }
}
