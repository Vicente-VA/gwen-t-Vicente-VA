package cl.uchile.dcc
package gwent.definitions.card.cardEffects.watherEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

class ClearWeather extends WeatherCardEffect {
  override val name: String = "Clear Weather"

  override def apply(self: WeatherCard, target: UnitCard): Unit = {
    target.setStrength(target.getBaseStrength)
  }

  val targetPlayer: String = "all"
  val targetCards: String = "section"
  var applied: Boolean = false
}
