package cl.uchile.dcc
package gwent.definitions.board
import gwent.definitions.Player
import gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, SiegeCard}
import gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable

/** NullBoard, tablero nulo con el que se inicializa un jugador
 *  Todos los metodos que juegan cartas retornan false para indicarle al jugador que no se pueden jugar cartas
 */
class NullBoard extends IBoard {
  var weatherSection: WeatherCard = WeatherCard("", "")
  val playerSections: Map[Player, Section] = Map()

  def playWeatherCard(c: WeatherCard): Boolean = false
  def playCloseCombatCard(p: Player, c: CloseCombatCard): Boolean = false
  def playDistanceCard(p: Player, c: DistanceCard): Boolean = false
  def playSiegeCard(p: Player, c: SiegeCard): Boolean = false

  def canEqual(that: Any): Boolean = {
    this.getClass.getName == that.getClass.getName
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[NullBoard]
      (this eq other) ||
        (this.weatherSection.getName == other.getWeatherSection.getName &&
          this.playerSections == other.getPlayerSection)
    } else false
  }

  def getWeatherSection: WeatherCard = this.weatherSection
  def getPlayerSection: Map[Player, Section] = this.playerSections
}
