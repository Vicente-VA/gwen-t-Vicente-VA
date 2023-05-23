/*Reminder: Un jugador debe tener Nombre, Seccion del tablero, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

package cl.uchile.dcc
package gwent.definitions
import cl.uchile.dcc.gwent.definitions.card.Card

import scala.collection.mutable

trait JugadorTrait:
  protected val Nombre: String
  protected val Seccion: Int
  protected var Gemas: Int
  protected var Mazo: Array[Card]
  protected var Mano: Array[Card]

class Jugador(val nombre: String, var mazo: Array[Card], var mano: Array[Card]){
  private var Nombre: String = nombre
  private val Seccion: Int = 0
  private var Gemas: Int = 2
  private var Mazo: Array[Card] = mazo
  private var Mano: Array[Card] = mano
  if (this.Nombre.isEmpty) {
    this.Nombre = "Jugador"
  }
  
  private def canEqual(that: Any): Boolean = that.isInstanceOf[Jugador]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Jugador]
      (this eq other) ||
        (this.Nombre == other.Nombre && 
          this.Seccion == other.Seccion && this.Gemas == other.Gemas && 
          (this.Mazo sameElements other.Mazo) && 
          (this.Mano sameElements this.Mano))
    } else false
  }

  def ver_nombre(): String = {
    this.Nombre
  }
  def ver_mazo(): Array[Card] = {
    this.Mazo
  }
  def ver_mano(): Array[Card] = {
    this.Mano
  }
  def cuanta_vida(): Int ={
    this.Gemas
  }
}