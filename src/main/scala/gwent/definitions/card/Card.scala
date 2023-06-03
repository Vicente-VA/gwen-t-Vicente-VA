/*Reminder: Hay dos clases de card; unidad y clima. Cada card tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/
package cl.uchile.dcc
package gwent.definitions.card

import cl.uchile.dcc.gwent.definitions.Player

import scala.collection.mutable

/** Card, interfaz comun para todas las cartas
 * 
 */
trait Card{
  val name: String
  val description: String

  /** Play, metodo para jugar la carta
   * 
   * @param player el jugador que va a jugar la carta
   * @return la implementacion del jugador para jugar el tipo de carta
   *         true si la carta se jugo correctamente
   *         false si no se pudo jugar la carta
   */
  def play(player: Player): Boolean
  
  def equals(that: Any): Boolean
  def getName: String
}