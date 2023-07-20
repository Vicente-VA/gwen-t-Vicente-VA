package cl.uchile.dcc
package gwent.cardCatalog.unitCards.siege

import gwent.definitions.card.unitCard.SiegeCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{MoraleBoost, UnitCardEffect}

class Kevin extends SiegeCard("Kevin", "A menace", 13){
  override val effect: UnitCardEffect = new MoraleBoost()
}
