package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.UnitCardEffect
import cl.uchile.dcc.gwent.definitions.card.cardEffects.watherEffects.NullWeatherEffect
import cl.uchile.dcc.gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, PlayUnit, SiegeCard, UnitCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.{PlayWeather, WeatherCard}

import scala.collection.mutable

/** Clase que representa al tablero donde se juega la partida
 *
 * @param P1 Uno de los jugadores, que en un principio sería una persona.
 * @param P2 Otro de los jugadores, que en un principio sería COM.
 *
 * @constructor Asigna este tablero a P1 y P2. Genera un tablero con una seccion para cada jugador y un espacio para
 *              cartas de clima
 */
class Board(P1: Player, P2: Player) extends IBoard {
  P1.setBoard(this)
  P2.setBoard(this)

  private var weatherSection: WeatherCard = WeatherCard("Clear","")
  private val playerSections: Map[Player,Section] = Map(
    P1 -> new Section(),
    P2 -> new Section()
  )

  def playWeatherCard(card: WeatherCard): Boolean = {
    weatherSection = card
    applyWeatherEffect(card)
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

  def applyWeatherEffect(card: WeatherCard): Unit = {
    for ((eachPlayer, eachSection) <- playerSections) {
      eachSection.applyWeatherEffect(card)
    }
  }

  def getWeatherSection: WeatherCard = this.weatherSection
  def getPlayerSection: Map[Player, Section] = this.playerSections

  /*
  EL TABLERO DEBE ENCARGARSE DE AVISAR/APLICAR A LAS CARTAS CUANDO UNA CARTA CON EFECTO ENTRE AL CAMPO
  LAS CARTAS DEBIESEN MODIFICAR SUS PROPIOS ATRIBUTOS
  OBSERVER ES PARA LA EP6
  REVISA VISITOR U OTRO APLICABLE
  */
}