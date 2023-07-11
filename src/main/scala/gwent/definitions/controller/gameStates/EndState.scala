package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

class EndState(context: GameController) extends GameState(context){
  override def toBeginningState(): Unit = {
    context.state = new BeginningState(context)
  }
}
