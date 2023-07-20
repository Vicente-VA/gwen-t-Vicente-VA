package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

class GameState(val context: GameController){
  context.state = this

  def play(mode: String): Unit = {}
  
  def toBeginningState(): Unit = {
    transitionError("BeginningState")
  }

  def toPlayerState(): Unit = {
    transitionError("PlayerState")
  }

  def toCOMState(): Unit = {
    transitionError("COMState")
  }

  def toEndState(): Unit = {
    transitionError("EndState")
  }


  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}

class InvalidTransitionException(message: String) extends Exception(message)