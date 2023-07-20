package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

import cl.uchile.dcc.gwent.cardCatalog.unitCards.closeCombat.{Dwarf, Knight, LinkButNowWithSword, WrenchDude}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.distance.{Decidueye, Legolas, LinkWithBow, SniperMonke}
import cl.uchile.dcc.gwent.cardCatalog.unitCards.siege.{Ballista, Bomber, Kevin}
import cl.uchile.dcc.gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy, Sunny}
import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.Board
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.cardEffects.watherEffects.ClearWeather

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Estado Inicial, en el que comienza el controlador y en el que se decide quien jugara primero
 * 
 * @param context es el controlador de juego al que se le asigno este estado
 */
class BeginningState(context: GameController) extends GameState(context){
  val name: String = "Beginning"

  override def toPlayerState(): Unit = {
    context.state = new PlayerState(context)
  }
  override def toCOMState(): Unit = {
    context.state = new COMState(context)
  }

  override def play(mode: String): Unit = {
    context.initialize(mode)
    println("Tossing a coin...")
    Thread.sleep(3000)
    var coin = -1
    mode match {
      case "player test" => coin = 0
      case "com test" => coin = 1
      case "real" => coin = Random.nextInt(2)
      case _ => throw new InvalidPlayMode(this.name, mode)
    }
    if (coin == 0){
      println("Heads! Your turn")
      toPlayerState()
    } else {
      println("Tails! The COM plays")
      toCOMState()
    }
    context.play(mode)
  }
}

class InvalidPlayMode(where: String, used: String) extends Throwable{
  println(s"Invalid mode called in $where . $used was used")
}