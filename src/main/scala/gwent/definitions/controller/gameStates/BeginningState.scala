package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

class BeginningState(context: GameController) extends GameState(context){
  override def toPlayerState(): Unit = {
    context.state = new PlayerState(context)
  }
  override def toCOMState(): Unit = {
    context.state = new COMState(context)
  }

  /*
  genPlayerDeck
  genCOMDeck
  init Player(context.playerName)
  tossCoin
  if tossedCoin -> toPlayerState
  else -> toCOMState
  */
}
