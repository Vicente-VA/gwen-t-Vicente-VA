package cl.uchile.dcc
package gwent.cardCatalog.unitCards.distance

import gwent.definitions.card.unitCard.DistanceCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{TightBond, UnitCardEffect}

class SniperMonke extends DistanceCard("SniperMonke", "Target neutralized", 9){
  override val effect: UnitCardEffect = new TightBond()
}
