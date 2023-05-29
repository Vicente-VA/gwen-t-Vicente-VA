package cl.uchile.dcc
package gwent.definitions.tablero

import gwent.definitions.card.WeatherCard
import cl.uchile.dcc.gwent.definitions.Player

trait TableroTrait{
  var weatherSection: WeatherCard
}

class Tablero(P1: Player, P2: Player) extends TableroTrait{

}