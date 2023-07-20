package cl.uchile.dcc
package definitions.card.cardEffects.weatherEffects

import gwent.cardCatalog.unitCards.closeCombat.WrenchDude
import gwent.cardCatalog.unitCards.distance.SniperMonke
import gwent.cardCatalog.unitCards.siege.Bomber
import gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy}
import gwent.definitions.Player
import gwent.definitions.board.{Board, IBoard, NullBoard}
import gwent.definitions.card.Card

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class ImpenetrableFogTest extends FunSuite {
  var P1: Player = new Player("P1", ArrayBuffer())
  var P2: Player = new Player("P2", ArrayBuffer())
  var board: IBoard = new NullBoard

  override def beforeEach(context: BeforeEach): Unit = {
    P1 = new Player("P1", ArrayBuffer(new WrenchDude, new SniperMonke, new Bomber,
                                              new WrenchDude, new SniperMonke, new Bomber,
                                              new WrenchDude, new SniperMonke, new Bomber,
                                              new Foggy, new Foggy, new Foggy))
    P2 = new Player("P2", ArrayBuffer(new WrenchDude, new SniperMonke, new Bomber,
                                              new WrenchDude, new SniperMonke, new Bomber,
                                              new WrenchDude, new SniperMonke, new Bomber,
                                              new Foggy, new Foggy, new Foggy))
    board = new Board(P1, P2)
  }

  test("El efecto funciona con las cartas de Distance") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 18)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 18)
    P2.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P2).getDistanceField(0).getStrength, 9)
    P2.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P2).getDistanceField(0).getStrength, 18)
    assertEquals(board.getPlayerSection(P2).getDistanceField(1).getStrength, 18)

    P1.playCard(new Foggy)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 1)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 1)
    assertEquals(board.getPlayerSection(P2).getDistanceField(0).getStrength, 1)
    assertEquals(board.getPlayerSection(P2).getDistanceField(1).getStrength, 1)
  }

  test("El efecto no se aplica a cartas de otras filas") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
    P1.playCard(new Foggy)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 1)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
  }
}