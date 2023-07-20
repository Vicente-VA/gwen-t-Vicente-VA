package cl.uchile.dcc
package gwent.definitions.controller

import gwent.definitions.board.{Board, IBoard, NullBoard}

import cl.uchile.dcc.gwent.cardCatalog.unitCards.closeCombat.{Dwarf, Knight, LinkButNowWithSword, WrenchDude}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.distance.{Decidueye, Legolas, LinkWithBow, SniperMonke}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.siege.{Ballista, Bomber, Kevin}
import cl.uchile.dcc.gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy, Sunny}
import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.controller.gameStates.{BeginningState, GameState}
import cl.uchile.dcc.gwent.definitions.controller.notifications.ControllerNotification

import java.util.jar.Attributes.Name
import scala.collection.mutable.ArrayBuffer

class GameController {
  var players: (Player, Player) = (null, null)
  var currentPlayer: Option[Player] = None
  var board: IBoard = new NullBoard()
  var state: GameState = new BeginningState(this)

  def initialize(mode: String): Unit = {
    var name = ""
    if (mode == "real") {
      println("Introduzca su nombre \n")
      name = scala.io.StdIn.readLine()
    } else name = "Player"

    val premadeDeck1: ArrayBuffer[Card] = ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    )

    val premadeDeck2: ArrayBuffer[Card] = ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    )

    val P1: Player = new Player(name, premadeDeck1)
    val COM: Player = new Player("COM", premadeDeck2)
    val board: Board = new Board(P1, COM)
    this.players = (P1, COM)
    this.board = board
    P1.setController(this)
    COM.setController(this)
  }

  def update(notification: ControllerNotification): Unit = {
    notification.takeAction(this)
  }

  def toBeginningState(): Unit = {
    state.toBeginningState()
  }

  def toPlayerState(): Unit = {
    state.toPlayerState()
  }

  def toCOMState(): Unit = {
    state.toCOMState()
  }

  def toEndState(): Unit = {
    state.toEndState()
  }

  def play(mode: String): Unit = {
    state.play(mode)
  }
}
