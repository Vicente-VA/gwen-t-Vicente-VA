package cl.uchile.dcc
package gwent.definitions.card

/** Clima, card jugable al centro
 *
 * @constructor crea una card de clima con nombre
 * @param name es el nombre de la card.
 *               es el unico valor pues el efecto que cause dependera de la card o el campo afectado
 */

class WeatherCard(val name: String, val description: String) extends Card{
  def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) ||
        (this.name == other.name &&
          this.description == other.description)
    } else false
  }
}


