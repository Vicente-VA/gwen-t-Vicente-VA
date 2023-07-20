package cl.uchile.dcc
package gwent.cardCatalog.unitCards.siege

import gwent.definitions.card.unitCard.SiegeCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{TightBond, UnitCardEffect}

class Bomber extends SiegeCard("Bomber", "The aircraft. This game is not balanced", 10){
  override val effect: UnitCardEffect = new TightBond()
}
