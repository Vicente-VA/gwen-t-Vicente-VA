package cl.uchile.dcc
package gwent.definitions.Controller

import gwent.definitions.board.{IBoard, NullBoard}

import cl.uchile.dcc.gwent.definitions.Player

class GameController {
  val playerMap: Map[String, Player] = Map()
  val board: IBoard = new NullBoard()
}
