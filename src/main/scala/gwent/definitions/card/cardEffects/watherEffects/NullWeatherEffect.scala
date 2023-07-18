package cl.uchile.dcc
package gwent.definitions.card.cardEffects.watherEffects
import gwent.definitions.card.unitCard.UnitCard
import gwent.definitions.card.weatherCard.WeatherCard

class NullWeatherEffect extends WeatherCardEffect {
  override def apply(self: WeatherCard, target: UnitCard): Unit = {}

  val name: String = ""
  val targetPlayer: String = ""
  val targetCards: String = ""
  var applied: Boolean = true
}
