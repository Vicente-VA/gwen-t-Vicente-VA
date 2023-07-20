package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

class TightBond extends atSelfRow {
  val name: String = "Tight Bond"

  def apply(self: UnitCard, target: UnitCard): Unit = {
    if (target.name == self.name){
      target.setBaseStrength(target.getStrength * 2)
      if (!this.applied) {
        self.setBaseStrength(self.getStrength * 2)
      }
    }

  }
}
