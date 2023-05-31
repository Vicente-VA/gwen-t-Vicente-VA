package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable

/** Clase que representa al tablero donde se juega la partida
 *
 * @param P1 Uno de los jugadores, que en un principio sería una persona.
 * @param P2 Otro de los jugadores, que en un principio sería COM.
 *
 * @constructor Asigna este tablero a P1 y P2. Genera un tablero con una seccion para cada jugador y un espacio para
 *              cartas de clima.
 */
class Board(P1: Player, P2: Player) extends BoardTrait{
  P1.setBoard(this)
  P2.setBoard(this)

  var weatherSection: WeatherCard = WeatherCard("Clear","")
  val playerSections: mutable.Map[Player,Section] = mutable.Map(
    P1 -> new Section(),
    P2 -> new Section()
  )

  def playWeatherCard(c: WeatherCard): Unit = {
    weatherSection = c
  }
  def playCloseCombatCard(player: Player, card: CloseCombatCard): Unit = {
    playerSections(player).playCloseCombatCard(card)
  }
  def playDistanceCard(player: Player, card: DistanceCard): Unit = {
    playerSections(player).playDistanceCard(card)
  }
  def playSiegeCard(player: Player, card: SiegeCard): Unit = {
    playerSections(player).playSiegeCard(card)
  }
}