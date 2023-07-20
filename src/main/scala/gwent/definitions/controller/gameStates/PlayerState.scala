package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

class PlayerState(context: GameController) extends GameState(context) {
  val name: String = "Player"
  
  override def toCOMState(): Unit = {
    context.state = new COMState(context)
  }

  override def toEndState(): Unit = {
    context.state = new EndState(context)
  }

  override def play(mode: String): Unit = {}
}
