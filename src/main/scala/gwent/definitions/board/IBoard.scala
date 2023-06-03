package cl.uchile.dcc
package gwent.definitions.board

import gwent.definitions.card.weatherCard.WeatherCard

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}

trait IBoard {
  def playCloseCombatCard(p: Player, c: CloseCombatCard): Boolean
  def playDistanceCard(p: Player, c: DistanceCard): Boolean
  def playSiegeCard(p: Player, c: SiegeCard): Boolean
  def playWeatherCard(c: WeatherCard): Boolean
  
  def getPlayerSection: Map[Player, Section]
  def getWeatherSection: WeatherCard
}
