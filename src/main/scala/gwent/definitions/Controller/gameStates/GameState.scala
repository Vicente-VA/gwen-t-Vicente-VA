package cl.uchile.dcc
package gwent.definitions.Controller.gameStates

import gwent.definitions.Controller.GameController

class GameState(val context: GameController){
  context.state = this

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}

class InvalidTransitionException(message: String) extends Exception(message)