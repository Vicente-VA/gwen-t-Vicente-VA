package cl.uchile.dcc
package gwent.definitions.card.cardEffects.watherEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard


/**
 * Biting Frost (Escarcha Mordiente)
 * 
 * Reduce el valor de fuerza de todas las cartas de CloseCombat a 1
 */
class BitingFrost extends WeatherCardEffect {
  override val name: String = "Biting Frost"

  override def apply(self: WeatherCard, target: UnitCard): Unit = {
    target.setStrength(1)
  }
  val targetPlayer: String = "all"
  val targetCards: String = "closeCombat"
  var applied: Boolean = false
}
