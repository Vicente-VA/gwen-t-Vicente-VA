package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, IPlayUnit, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.{IPlayWeather, WeatherCard}

import scala.collection.mutable

/** Clase que representa al tablero donde se juega la partida
 *
 * @param P1 Uno de los jugadores, que en un principio sería una persona.
 * @param P2 Otro de los jugadores, que en un principio sería COM.
 *
 * @constructor Asigna este tablero a P1 y P2. Genera un tablero con una seccion para cada jugador y un espacio para
 *              cartas de clima.
 */
class Board(P1: Player, P2: Player) extends IBoard {
  P1.setBoard(this)
  P2.setBoard(this)

  private var weatherSection: WeatherCard = WeatherCard("Clear","")
  private val playerSections: Map[Player,Section] = Map(
    P1 -> new Section(),
    P2 -> new Section()
  )

  def playWeatherCard(c: WeatherCard): Boolean = {
    weatherSection = c
    true
  }
  def playCloseCombatCard(player: Player, card: CloseCombatCard): Boolean = {
    playerSections(player).playCloseCombatCard(card)
  }
  def playDistanceCard(player: Player, card: DistanceCard): Boolean = {
    playerSections(player).playDistanceCard(card)
  }
  def playSiegeCard(player: Player, card: SiegeCard): Boolean = {
    playerSections(player).playSiegeCard(card)
  }

  def getWeatherSection: WeatherCard = this.weatherSection
  def getPlayerSection: Map[Player, Section] = this.playerSections
}