/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions

import gwent.definitions.board
import gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, PlayUnit, SiegeCard}
import gwent.definitions.card.weatherCard.{PlayWeather, WeatherCard}
import gwent.definitions.card.Card

import cl.uchile.dcc.gwent.definitions.board.{Board, IBoard, NullBoard}
import cl.uchile.dcc.gwent.definitions.controller.GameController
import cl.uchile.dcc.gwent.definitions.controller.notifications.{ControllerNotification, deadPlayerNotification}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Player(private val _name: String, private val _deck: ArrayBuffer[Card]) extends PlayUnit with PlayWeather {
  private var name = _name
  private var gems: Int = 2
  private var deck: ArrayBuffer[Card] = _deck.map(identity)
  private val hand: ArrayBuffer[Card] = ArrayBuffer()
  private var board: IBoard = NullBoard()
  private var controller: GameController = new GameController()
  if (this.name.isEmpty) {
    this.name = "Player"
  }

  def setController(gameController: GameController): Unit = {
    controller = gameController
  }

  private def notifyController(alert: ControllerNotification): Unit = {
    controller.update(alert)
  }

  /** playCard, juega la carta indicada desde la mano del jugador al tablero asignado al jugador
   *  Utiliza los metodos implementados por PlayUnit y PlayWeather
   *  Si no se encuentra la carta en la mano, se imprime un mensaje a consola
   * 
   * @param card es la carta a jugar, que debe estar en la mano del jugador
   * @return true si la carta se jugó exitosamente
   *         false si no fue asi
   */
  def playCard(card: Card): Boolean ={
    val ind = hand.indexWhere(_.name == card.name)
    if(ind == -1){
      println("There's no such card on your hand!")
      false
    } else {
      hand(ind).play(this)
    }
  }

  /** Juega una carta de tipo CloseCombatCard en el tablero asignado al jugador
   *
   * @param card es la carta jugada
   * @return true si la carta se jugo exitosamente, eliminandola de la mano del jugador
   *         false si la carta no se pudo jugar, imprimiento en consola "You cannot play this card!"
   */
  def playCloseCombatCard(card: CloseCombatCard): Boolean = {
    val ind = hand.indexWhere(_.name == card.name)
    val didPlayCard: Boolean = this.board.playCloseCombatCard(this, card)
    if (didPlayCard) {
      hand.remove(ind)
      true
    } else {
      println("You cannot play this card!")
      false
    }
  }

  /** Juega una carta de tipo DistanceCard en el tablero asignado al jugador
   *
   * @param card es la carta jugada
   * @return true si la carta se jugo exitosamente, eliminandola de la mano del jugador
   *         false si la carta no se pudo jugar, imprimiento en consola "You cannot play this card!"
   */
  def playDistanceCard(card: DistanceCard): Boolean = {
    val ind = hand.indexWhere(_.name == card.name)
    val didPlayCard: Boolean = board.playDistanceCard(this, card)
    if (didPlayCard) {
      hand.remove(ind)
      true
    } else {
      println("You cannot play this card!")
      false
    }
  }

  /** Juega una carta de tipo SiegeCard en el tablero asignado al jugador
   *
   * @param card es la carta jugada
   * @return true si la carta se jugo exitosamente, eliminandola de la mano del jugador
   *         false si la carta no se pudo jugar, imprimiento en consola "You cannot play this card!"
   */
  def playSiegeCard(card: SiegeCard): Boolean = {
    val ind = hand.indexWhere(_.name == card.name)
    val didPlayCard: Boolean = this.board.playSiegeCard(this, card)
    if (didPlayCard) {
      hand.remove(ind)
      true
    } else {
      println("You cannot play this card!")
      false
    }
  }

  /** Juega una carta de tipo WeatherCard en el tablero asignado al jugador
   *
   * @param card es la carta jugada
   * @return true si la carta se jugo exitosamente, eliminandola de la mano del jugador
   *         false si la carta no se pudo jugar, imprimiento en consola "You cannot play this card!"
   */
  def playWeatherCard(card: WeatherCard): Boolean = {
    val ind = hand.indexWhere(_.name == card.name)
    val didPlayCard: Boolean = this.board.playWeatherCard(card)
    if (didPlayCard) {
      hand.remove(ind)
      true
    } else {
      println("You cannot play this card!")
      false
    }
  }

  /** shuffleDeck, metodo para revolver el mazo del jugador
   * 
   */
  def shuffleDeck(): Unit = {
    deck = scala.util.Random.shuffle(deck)
  }

  /** drawCard, metodo para extraer cartas del mazo a la mano
   *  Saca la cantidad de cartas indicada.
   *  - Si el mazo esta vacio, no saca nada e imprime un mensaje a consola
   *  - Si la cantidad de cartas a sacar es mayor que las que hay en el mazo, saca todas las que quedan
   *  - Si la cantidad de cartas es negativa, no saca ninguna e imprime un mensaje a la consola
   * 
   * @param int es la cantidad de cartas a sacar del mazo
   */
  def drawCard(int: Int): Unit = {
    if (deck.isEmpty){
      println("Your deck is empty!")
    }
    else if(deck.length < int){
      drawCard(deck.length)
    }
    else if (0 <= int){
      hand ++= deck.take(int)
      deck.remove(0,int)
      shuffleDeck()
    } else {
      println("You can't draw a negative amount of cards!")
    }
  }

  private def canEqual(that: Any): Boolean = {this.getClass.getName == that.getClass.getName}
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (name == other.getName &&
          gems == other.getGems &&
          deck == other.getDeck &&
          hand == other.getHand)
    } else false
  }

  def getName: String = name
  def getDeck: ArrayBuffer[Card] = deck.map(identity)
  def getHand: ArrayBuffer[Card] = hand.map(identity)
  def getGems: Int = gems
  def getBoard: IBoard = board

  def setGems(int: Int): Unit = {
    gems = int
    if (gems < 0) {
      gems = 0
    }
    if (gems == 0){
      notifyController(new deadPlayerNotification(this))
    }
  }

  /** setBoard, metodo utilizado para asignar un tablero al jugador
   * 
   * @param someBoard es el tablero en el que el jugador jugara sus cartas
   *                  se asigna al inicalizar un tablero Board
   */
  def setBoard(someBoard: IBoard): Unit = {this.board = someBoard}
}