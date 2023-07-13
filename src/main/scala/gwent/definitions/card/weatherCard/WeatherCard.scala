package cl.uchile.dcc
package gwent.definitions.card.weatherCard

import gwent.definitions.card.Card

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.cardEffects.{CardEffect, NullEffect}

/** Carta de clima, jugable en WeatherSection del tablero
 *
 * @constructor crea una card de clima con name
 * @param name es el name de la card.
 *               es el unico valor pues el efecto que cause dependera de la card o el campo afectado
 */

class WeatherCard(val name: String, val description: String, val effect: CardEffect = new NullEffect) extends Card {


  def canEqual(that: Any): Boolean = {this.getClass.getName == that.getClass.getName}
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) ||
        (this.name == other.name &&
          this.description == other.description)
    } else false
  }

  def play(player: Player): Boolean = {
    player.playWeatherCard(this)
  }

  def getName: String = {
    this.name
  }
}


