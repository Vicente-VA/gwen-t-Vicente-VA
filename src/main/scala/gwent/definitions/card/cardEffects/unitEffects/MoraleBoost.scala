package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

class MoraleBoost extends atSelfRow {
  override val name: String = "Morale Boost"

  def apply(self: UnitCard, target: UnitCard): Unit = {
    target.setStrength(target.getStrength + 1)
  }
}
