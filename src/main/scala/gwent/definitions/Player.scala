/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions

import gwent.definitions.board.{Board, Section}
import gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import gwent.definitions.card.weatherCard.WeatherCard
import gwent.definitions.card.{Card, PlayCard}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Player(private var name: String, private val deck: ArrayBuffer[Card]) extends PlayCard{
  private var Gems: Int = 2
  private val Deck: ArrayBuffer[Card] = deck.map(identity)
  private val Hand: ArrayBuffer[Card] = ArrayBuffer()
  private var board: Option[Board] = None
  if (this.name.isEmpty) {
    this.name = "Player"
  }

  def playCard(card: Card): Unit ={
    val ind = this.Hand.indexWhere(_.getName == card.getName)
    if(ind == -1){
      println("There's no such card on your hand!")
    } else {
      Hand(ind).play(this)
      Hand.remove(ind)
    }
  }
  def playCloseCombatCard(card: CloseCombatCard): Unit = {
    board.foreach(_.playCloseCombatCard(this, card))
  }
  def playDistanceCard(card: DistanceCard): Unit = {
    board.foreach(_.playDistanceCard(this, card))
  }
  def playSiegeCard(card: SiegeCard): Unit = {
    board.foreach(_.playSiegeCard(this, card))
  }
  def playWeatherCard(card: WeatherCard): Unit = {
    board.foreach(_.playWeatherCard(card))
  }

  private def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (this.name == other.getName &&
          this.Gems == other.getGems &&
          this.Deck == other.getDeck &&
          this.Hand == other.getHand)
    } else false
  }

  def getName: String = this.name
  def getDeck: ArrayBuffer[Card] = this.Deck
  def getHand: ArrayBuffer[Card] = this.Hand
  def getGems: Int = this.Gems

  def setGems(i: Int): Unit = {this.Gems += i}
  def setBoard(someBoard: Board): Unit = {this.board = Some(someBoard)}
}