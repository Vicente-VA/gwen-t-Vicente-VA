package cl.uchile.dcc
package gwent.definitions.controller.notifications

import gwent.definitions.controller.GameController

trait ControllerNotification {
  def takeAction(controller: GameController): Unit
}