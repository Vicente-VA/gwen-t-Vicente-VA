package cl.uchile.dcc
package gwent.definitions.board
import gwent.definitions.Player
import gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable

class NullBoard extends IBoard {
  var weatherSection: WeatherCard = WeatherCard("","")
  val playerSections: mutable.Map[Player, Section] = mutable.Map()

  def playWeatherCard(c: WeatherCard): Boolean = false
  def playCloseCombatCard(p: Player, c: CloseCombatCard): Boolean = false
  def playDistanceCard(p: Player, c: DistanceCard): Boolean = false
  def playSiegeCard(p: Player, c: SiegeCard): Boolean = false
}
