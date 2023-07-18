package cl.uchile.dcc
package gwent.cardCatalog.unitCards.distance

import gwent.definitions.card.unitCard.DistanceCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{MoraleBoost, UnitCardEffect}

class Legolas extends DistanceCard("Legolas", "And you have my bow", 3){
  override val effect: UnitCardEffect = new MoraleBoost()
}
