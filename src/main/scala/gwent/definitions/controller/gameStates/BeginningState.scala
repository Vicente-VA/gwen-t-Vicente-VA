package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

import cl.uchile.dcc.gwent.cardCatalog.unitCards.closeCombat.{Dwarf, Knight, LinkButNowWithSword, WrenchDude}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.distance.{Decidueye, Legolas, LinkWithBow, SniperMonke}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.siege.{Ballista, Bomber, Kevin}
import cl.uchile.dcc.gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy, Sunny}
import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.cardEffects.watherEffects.ClearWeather

import scala.collection.mutable.ArrayBuffer

class BeginningState(context: GameController) extends GameState(context){
  override def toPlayerState(): Unit = {
    context.state = new PlayerState(context)
  }
  override def toCOMState(): Unit = {
    context.state = new COMState(context)
  }

  override def play(mode: String): Unit = {
    var name = ""
    if (mode == "real"){
      println("Introduzca su nombre \n")
      name = scala.io.StdIn.readLine()
    } else name = "Player"

    val premadeDeck: ArrayBuffer[Card] = ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    )

    val P1: Player = new Player(name, ArrayBuffer())
    val COM: Player = new Player("COM", ArrayBuffer())

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
