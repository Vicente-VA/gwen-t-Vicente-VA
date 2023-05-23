package cl.uchile.dcc
package gwent.definitions.card



/** AbstractUnitCard: Clase abstracta para las cartas de unidad
 *
 *  @constructor crea una unidad con nombre, fuerza. puede incluir ademas un efecto especial.
 *  @param clase es la clase de la carta que define donde puede ser jugada. puede ser CaC, Distancia o Asedio.
 *  @param fuerza es la fuerza de la carta, expresada en un valor entero mayor o igual a 0.
 *  @param efecto es un efecto especial que puede o no tener la carta.
 */
abstract class AbstractUnitCard protected(val name: String, val description: String,
                                          val strength: Int) extends Card{
  var currentStrength: Int = strength
  if (this.currentStrength < 0) {
    this.currentStrength = 0
  }
  def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractUnitCard]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractUnitCard]
      (this eq other) ||
        (this.name == other.name &&
          this.strength == other.strength &&
          this.description == other.description)
    } else false
  }
  def get_str(): Int = {
    this.currentStrength
  }
}