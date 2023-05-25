package cl.uchile.dcc
package gwent.definitions.card



/** AbstractUnitCard: Clase abstracta para las cartas de unidad
 *
 *  @constructor crea una unidad con nombre, fuerza. puede incluir ademas un efecto especial.
 *  @param strength es la fuerza de la carta, expresada en un valor entero mayor o igual a 0.
 *  @param description es una descripción de la carta. puede incluir características de alguna habilidad de la carta o
 *                     de la historia (lore) de esta.
 */
abstract class AbstractUnitCard protected(val name: String, val description: String,
                                          val strength: Int) extends Card{
  var currentStrength: Int = this.strength
  if (this.currentStrength < 0) {
    this.currentStrength = 0
  }
  def get_str(): Int = {
    this.currentStrength
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
}