/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions

import gwent.definitions.board
import gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, IPlayUnit, SiegeCard}
import gwent.definitions.card.weatherCard.{IPlayWeather, WeatherCard}
import gwent.definitions.card.{Card, PlayCard}

import cl.uchile.dcc.gwent.definitions.board.{IBoard,Board,NullBoard}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Player(private var Name: String, private val Deck: ArrayBuffer[Card]) extends IPlayUnit with IPlayWeather{
  private var name = Name
  private var gems: Int = 2
  private val deck: ArrayBuffer[Card] = deck.map(identity)
  private val hand: ArrayBuffer[Card] = ArrayBuffer()
  private var board: IBoard = NullBoard()
  if (this.name.isEmpty) {
    this.name = "Player"
  }

  def playCard(card: Card): Unit ={
    val ind = this.hand.indexWhere(_.getName == card.getName)
    if(ind == -1){
      println("There's no such card on your hand!")
    } else {
      this.hand(ind).play(this)
    }
  }
  def playCloseCombatCard(card: CloseCombatCard): Unit = {
    val ind = this.hand.indexWhere(_.getName == card.getName)
    if(this.board.playCloseCombatCard(this, card)){
      this.hand.remove(ind)
    } else {
      println("You cannot play this card!")
    }
  }
  def playDistanceCard(card: DistanceCard): Unit = {
    val ind = this.hand.indexWhere(_.getName == card.getName)
    if (this.board.playDistanceCard(this, card)) {
      this.hand.remove(ind)
    } else {
      println("You cannot play this card!")
    }
  }
  def playSiegeCard(card: SiegeCard): Unit = {
    val ind = this.hand.indexWhere(_.getName == card.getName)
    if (this.board.playSiegeCard(this, card)) {
      this.hand.remove(ind)
    } else {
      println("You cannot play this card!")
    }
  }
  def playWeatherCard(card: WeatherCard): Unit = {
    val ind = this.hand.indexWhere(_.getName == card.getName)
    if (this.board.playWeatherCard(card)) {
      this.hand.remove(ind)
    } else {
      println("You cannot play this card!")
    }
  }

  private def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (this.name == other.getName &&
          this.gems == other.getGems &&
          this.deck == other.getDeck &&
          this.hand == other.getHand)
    } else false
  }

  def getName: String = this.name
  def getDeck: ArrayBuffer[Card] = this.deck
  def getHand: ArrayBuffer[Card] = this.hand
  def getGems: Int = this.gems

  def setGems(i: Int): Unit = {this.gems += i}
  def setBoard(someBoard: IBoard): Unit = {this.board = someBoard}
}