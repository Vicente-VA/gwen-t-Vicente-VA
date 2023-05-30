/*Reminder: Hay dos clases de card; unidad y clima. Cada card tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/
package cl.uchile.dcc
package gwent.definitions.card

import cl.uchile.dcc.gwent.definitions.board.Board

import scala.collection.mutable

trait Card{
  val name: String
  val description: String
  def play(board: Board): Unit
}