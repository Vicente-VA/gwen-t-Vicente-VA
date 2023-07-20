package cl.uchile.dcc
package definitions.card.cardEffects.weatherEffects

import gwent.cardCatalog.unitCards.closeCombat.{Dwarf, Knight, LinkButNowWithSword, WrenchDude}
import gwent.cardCatalog.unitCards.distance.{Decidueye, Legolas, LinkWithBow, SniperMonke}
import gwent.cardCatalog.unitCards.siege.{Ballista, Bomber, Kevin}
import gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy, Sunny}
import gwent.definitions.Player
import gwent.definitions.board.{Board, IBoard}
import gwent.definitions.card.Card

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class ClearWeatherTest extends FunSuite {
  var P1: Player = new Player("P1", ArrayBuffer())
  var P2: Player = new Player("P2", ArrayBuffer())
  var board: IBoard = new Board(P1, P2)

  override def beforeEach(context: BeforeEach): Unit = {
    P1 = new Player("P1", ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    ))
    P2 = new Player("P2", ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    ))
    board = new Board(P1, P2)
  }

  test("El efecto funciona con las cartas de CloseCombat") {
    P1.drawCard(25)
    P2.drawCard(25)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 3)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 3)
    P1.playCard(new Snowy)
    P1.playCard(new Sunny)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 3)
  }

  test("El efecto funciona con las cartas de Distance") {
    P1.drawCard(25)
    P2.drawCard(25)
    P1.playCard(new Legolas)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 3)
    P1.playCard(new Legolas)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 3)
  }

  test("El efecto funciona con las cartas de Siege") {
    P1.drawCard(25)
    P2.drawCard(25)
    P1.playCard(new Kevin)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 13)
    P1.playCard(new Kevin)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 14)
    assertEquals(board.getPlayerSection(P1).getSiegeField(1).getStrength, 13)
  }

  test("El efecto no se aplica a cartas de otras filas") {
    P1.drawCard(25)
    P2.drawCard(25)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
    P1.playCard(new Sunny)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
  }
}