package cl.uchile.dcc
package definitions.card.cardEffects.weatherEffects

import gwent.cardCatalog.unitCards.closeCombat.{Dwarf, WrenchDude}
import gwent.cardCatalog.unitCards.distance.{Legolas, SniperMonke}
import gwent.cardCatalog.unitCards.siege.{Bomber, Kevin}
import gwent.cardCatalog.weatherCards.Snowy
import gwent.definitions.Player
import gwent.definitions.board.{Board, IBoard}
import gwent.definitions.card.Card

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class ClearWeatherTest extends FunSuite {
  val startingDeck: ArrayBuffer[Card] = ArrayBuffer(new WrenchDude, new SniperMonke, new Bomber,
    new WrenchDude, new SniperMonke, new Bomber,
    new WrenchDude, new SniperMonke, new Bomber,
    new Snowy, new Snowy, new Snowy)
  var P1: Player = new Player("P1", startingDeck.map(identity))
  var P2: Player = new Player("P2", startingDeck.map(identity))
  var board: IBoard = new Board(P1, P2)

  override def beforeEach(context: BeforeEach): Unit = {
    var P1: Player = new Player("P1", startingDeck.map(identity))
    var P2: Player = new Player("P2", startingDeck.map(identity))
    var board: IBoard = new Board(P1, P2)
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

  test("El efecto no se aplica a cartas de otras filas") {
    P1.drawCard(20)
    P2.drawCard(20)
    P1.playCard(new SniperMonke)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    P1.playCard(new Bomber)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
    P1.playCard(new Snowy)
    assertEquals(board.getPlayerSection(P1).getDistanceField(0).getStrength, 9)
    assertEquals(board.getPlayerSection(P1).getSiegeField(0).getStrength, 10)
  }
}