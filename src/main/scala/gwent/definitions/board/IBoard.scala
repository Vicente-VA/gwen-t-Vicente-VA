package cl.uchile.dcc
package gwent.definitions.board

import gwent.definitions.card.weatherCard.WeatherCard

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, SiegeCard}

/** IBoard, interfaz para modelar el tablero y tablero nulo
 *  Implementa los metodos necesarios para el Double Dispatch de las posibles cartas a jugar
 *  Se retornan booleanos para analisis de casos borde y evitar el uso de excepciones
 */
trait IBoard {
  /** Juega una carta de tipo CloseCombatCard en la seccion que le corresponde a player
   *
   * @param player es el jugador que jugó la carta, y clave para el map de playerSections
   * @param card   es la carta jugada
   * @return la implementacion de esta funcion en Section
   *
   * @see documentacion de PlayUnit
   */
  def playCloseCombatCard(player: Player, card: CloseCombatCard): Boolean

  /** Juega una carta de tipo ** en la seccion que le corresponde a player
   *
   * @param player es el jugador que jugó la carta, y clave para el map de playerSections
   * @param card   es la carta jugada
   * @return la implementacion de esta funcion en Section
   * @see documentacion de PlayUnit
   */
  def playDistanceCard(player: Player, card: DistanceCard): Boolean

  /** Juega una carta de tipo ** en la seccion que le corresponde a player
   *
   * @param player es el jugador que jugó la carta, y clave para el map de playerSections
   * @param card   es la carta jugada
   * @return la implementacion de esta funcion en Section
   * @see documentacion de PlayUnit
   */
  def playSiegeCard(player: Player, card: SiegeCard): Boolean

  /** Juega una carta de tipo ** en la seccion que le corresponde a player
   *
   * @param card es la carta jugada
   * @return la implementacion de esta funcion en Section
   * @see documentacion de IPlayWeatherCard
   */
  def playWeatherCard(card: WeatherCard): Boolean

  def getPlayerSection: Map[Player, Section]
  def getWeatherSection: WeatherCard
  
  def applyWeatherEffect(card: WeatherCard): Unit
}
