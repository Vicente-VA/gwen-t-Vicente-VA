package cl.uchile.dcc
package gwent.definitions.board

import gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import gwent.definitions.card.weatherCard.WeatherCard

import cl.uchile.dcc.gwent.definitions.Player

import scala.collection.mutable

trait BoardTrait{
  var weatherSection: WeatherCard
  val playerSections: mutable.Map[Player,Section]
  def playWeatherCard(c: WeatherCard): Unit
  def playCloseCombatCard(p: Player, c: CloseCombatCard): Unit
  def playDistanceCard(p: Player, c: DistanceCard): Unit
  def playSiegeCard(p: Player, c: SiegeCard): Unit
}