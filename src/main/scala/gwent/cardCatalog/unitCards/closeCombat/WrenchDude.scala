package cl.uchile.dcc
package gwent.cardCatalog.unitCards.closeCombat

import gwent.definitions.card.unitCard.CloseCombatCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{TightBond, UnitCardEffect}

class WrenchDude extends CloseCombatCard("WrenchDude", "He has a wrench!", 2) {
  override val effect: UnitCardEffect = new TightBond()
}
