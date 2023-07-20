package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

class COMState(context: GameController) extends GameState(context){
  val name: String = "COM"
  
  override def toPlayerState(): Unit = {
    context.state = new PlayerState(context)
  }
  override def toEndState(): Unit = {
    context.state = new EndState(context)
  }

  override def play(mode: String): Unit = {}
}
