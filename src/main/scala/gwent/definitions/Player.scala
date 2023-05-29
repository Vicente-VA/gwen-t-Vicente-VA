/*Reminder: Un jugador debe tener Nombre, Seccion del tablero, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.tablero.Section

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait PlayerTrait{
  val Nombre: String
  val Seccion: Int
  var Gemas: Int
  val Mazo: ArrayBuffer[Card]
  val Mano: ArrayBuffer[Card]
}


class Player(val name: String, var deck: ArrayBuffer[Card]){
  private var Name: String = name
  private var Gems: Int = 2
  private val Deck: ArrayBuffer[Card] = deck
  private val Hand: ArrayBuffer[Card] = ArrayBuffer()
  private val Field: Section = new Section
  if (this.Name.isEmpty) {
    this.Name = "Player"
  }

  private def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (this.Name == other.Name &&
          this.Field == other.Field && this.Gems == other.Gems &&
          this.Deck == other.Deck &&
          this.Hand == other.Hand)
    } else false
  }

  def getName: String = {
    this.Name
  }
  def getDeck: ArrayBuffer[Card] = {
    this.Deck
  }
  def getHand: ArrayBuffer[Card] = {
    this.Hand
  }
  def getGems: Int ={
    this.Gems
  }

  def setGems(i: Int): Unit = {
    this.Gems += i
  }
}