package cl.uchile.dcc
package definitions.card.cardEffects.unitEffects

import cl.uchile.dcc.gwent.cardCatalog.unitCards.siege.*
import cl.uchile.dcc.gwent.cardCatalog.unitCards.distance.*
import cl.uchile.dcc.gwent.cardCatalog.unitCards.closeCombat.{Dwarf, *}
import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.{Board, IBoard, NullBoard}
import cl.uchile.dcc.gwent.definitions.card.Card
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class MoraleBoostTest extends FunSuite{
  var P1: Player = new Player("P1", ArrayBuffer())
  var P2: Player = new Player("P2", ArrayBuffer())
  var board: IBoard = new NullBoard

  override def beforeEach(context: BeforeEach): Unit = {
    P1 = new Player("P1", ArrayBuffer(new Dwarf, new Legolas, new Kevin,
                                                          new Dwarf, new Legolas, new Kevin,
                                                          new Dwarf, new Legolas, new Kevin))
    P2 = new Player("P2", ArrayBuffer(new Dwarf, new Legolas, new Kevin,
                                                          new Dwarf, new Legolas, new Kevin,
                                                          new Dwarf, new Legolas, new Kevin))
    board = new Board(P1, P2)
  }

  test("El efecto funciona con las cartas de CloseCombat") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 3)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 3)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 5)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(2).getStrength, 3)
  }

  test("El efecto funciona con las cartas de Distance") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new Legolas)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 3)
    P1.playCard(new Legolas)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 3)
    P1.playCard(new Legolas)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 5)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getDistanceField(2).getStrength, 3)
  }

  test("El efecto funciona con las cartas de Siege") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new Kevin)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 13)
    P1.playCard(new Kevin)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 14)
    assertEquals(board.getPlayerSection(P1).getSiegeField(1).getStrength, 13)
    P1.playCard(new Kevin)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 15)
    assertEquals(board.getPlayerSection(P1).getSiegeField(1).getStrength, 14)
    assertEquals(board.getPlayerSection(P1).getSiegeField(2).getStrength, 13)
  }

  test("El efecto solo actua sobre el jugador que jugo la carta") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new Dwarf)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 3)
//    P1.playCard(new Dwarf)
//    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
//    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 3)
//    P2.playCard(new Dwarf)
//    assertEquals(board.getPlayerSection(P2).getCloseCombatField(0).getStrength, 3)
//    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 3)
//    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
  }
}
