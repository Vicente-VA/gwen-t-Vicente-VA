package cl.uchile.dcc
package gwent.definitions.controller.notifications

import gwent.definitions.Player

import cl.uchile.dcc.gwent.definitions.controller.GameController

class deadPlayerNotification(player: Player) extends ControllerNotification{
  def takeAction(controller: GameController): Unit = {
    
  }
}