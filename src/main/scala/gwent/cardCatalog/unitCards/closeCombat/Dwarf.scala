package cl.uchile.dcc
package gwent.cardCatalog.unitCards.closeCombat

import gwent.definitions.card.unitCard.CloseCombatCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{MoraleBoost, UnitCardEffect}

class Dwarf extends CloseCombatCard("Dwarf", "Rock and stone!!", 3) {
  override val effect: UnitCardEffect = new MoraleBoost()
}
