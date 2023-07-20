package cl.uchile.dcc
package definitions.card.cardEffects.unitEffects

import cl.uchile.dcc.gwent.cardCatalog.unitCards.closeCombat.WrenchDude
import cl.uchile.dcc.gwent.cardCatalog.unitCards.distance.SniperMonke
import cl.uchile.dcc.gwent.cardCatalog.unitCards.siege.Bomber
import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.{Board, IBoard, NullBoard}
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unitCard.UnitCard
import munit.FunSuite

import scala.collection.mutable.{ArrayBuffer, ArrayStack}

class TightBondTest extends FunSuite{
  var P1: Player = new Player("", ArrayBuffer())
  var P2: Player = new Player("", ArrayBuffer())
  var board: IBoard = new NullBoard()

  var deck1: ArrayBuffer[Card] = ArrayBuffer()
  var deck2: ArrayBuffer[Card] = ArrayBuffer()

  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = ArrayBuffer(new WrenchDude, new SniperMonke, new Bomber,
                        new WrenchDude, new SniperMonke, new Bomber,
                        new WrenchDude, new SniperMonke, new Bomber)
    deck2 = ArrayBuffer(new WrenchDude, new SniperMonke, new Bomber,
                        new WrenchDude, new SniperMonke, new Bomber,
                        new WrenchDude, new SniperMonke, new Bomber)
    P1 = new Player("P1", deck1)
    P2 = new Player("P2", deck2)
    board = new Board(P1, P2)
  }

  test("El efecto funciona con las cartas de CloseCombat") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 2)
    P1.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 4)
    P1.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 8)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 8)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(2).getStrength, 8)

  }

  test("El efecto funciona con las cartas de Distance") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 18)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 18)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 36)
    assertEquals(board.getPlayerSection(P1).getDistanceField(1).getStrength, 36)
    assertEquals(board.getPlayerSection(P1).getDistanceField(2).getStrength, 36)
  }

  test("El efecto funciona con las cartas de Siege") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 20)
    assertEquals(board.getPlayerSection(P1).getSiegeField(1).getStrength, 20)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 40)
    assertEquals(board.getPlayerSection(P1).getSiegeField(1).getStrength, 40)
    assertEquals(board.getPlayerSection(P1).getSiegeField(2).getStrength, 40)
  }

  test("Efecto solo actua sobre el jugador que juega la carta"){
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 2)
    P1.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 4)
    P2.playCard(new WrenchDude)
    assertEquals(board.getPlayerSection(P2).getCloseCombatField(0).getStrength, 2)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(0).getStrength, 4)
    assertEquals(board.getPlayerSection(P1).getCloseCombatField(1).getStrength, 4)
  }
}