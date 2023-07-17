package cl.uchile.dcc
package gwent.definitions.controller

import gwent.definitions.board.{IBoard, NullBoard}

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.controller.gameStates.{BeginningState, GameState}
import cl.uchile.dcc.gwent.definitions.controller.notifications.ControllerNotification

class GameController {
  val currentPlayer: Option[Player] = None
  val board: IBoard = new NullBoard()
  var state: GameState = new BeginningState(this)

  def update(notification: ControllerNotification): Unit = {
    notification.takeAction(this)
  }

  def play(): Unit = {
    state.play()
  }
}
