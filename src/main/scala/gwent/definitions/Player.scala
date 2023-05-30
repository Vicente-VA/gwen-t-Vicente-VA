/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.board.{Board, Section}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Player(private var name: String, private var deck: ArrayBuffer[Card], private val board: Board){
  private var Gems: Int = 2
  private val Deck: ArrayBuffer[Card] = deck.map(identity)
  private val onHand: ArrayBuffer[Card] = ArrayBuffer()
  private val onField: Section = new Section()
  if (this.name.isEmpty) {
    this.name = "Player"
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

}