/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions
import cl.uchile.dcc.gwent.definitions.card.{Card, PlayCard}
import cl.uchile.dcc.gwent.definitions.board.{Board, Section}
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Player(private var name: String, private var deck: ArrayBuffer[Card], private var board: Board) extends PlayCard{
  private var Gems: Int = 2
  private val Deck: ArrayBuffer[Card] = deck.map(identity)
  private val onHand: ArrayBuffer[Card] = ArrayBuffer()
  private val onField: Section = new Section()
  if (this.name.isEmpty) {
    this.name = "Player"
  }

  def playCard(card: Card): Unit ={
    card.play(this)
  }
  def playCloseCombatCard(card: CloseCombatCard): Unit = {
    board.playCloseCombatCard(this, card)
  }
  def playDistanceCard(card: DistanceCard): Unit = {
    board.playDistanceCard(this, card)
  }
  def playSiegeCard(card: SiegeCard): Unit = {
    board.playSiegeCard(this, card)
  }
  def playWeatherCard(card: WeatherCard): Unit = {
    board.playWeatherCard(card)
  }


  private def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (this.name == other.getName &&
          this.onField == other.getOnField &&
          this.Gems == other.getGems &&
          this.Deck == other.getDeck &&
          this.onHand == other.getHand)
    } else false
  }

  

  def getName: String ={
    this.name
  }
  def getDeck: ArrayBuffer[Card] = {
    this.Deck
  }
  def getHand: ArrayBuffer[Card] = {
    this.onHand
  }
  def getGems: Int ={
    this.Gems
  }
  def getOnField: Section = {
    this.onField
  }

  def setGems(i: Int): Unit = {
    this.Gems += i
  }

  def setBoard(someBoard: Board): Unit = {
    this.board = someBoard
  }
}