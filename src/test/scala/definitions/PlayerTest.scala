/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas
* Ademas, sete debe poder robar cartas de su baseDeck y jugar cartas de su mano*/
package cl.uchile.dcc
package gwent.definitions

import cl.uchile.dcc.gwent.definitions.board.{Board, NullBoard}
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable
import munit.FunSuite

import scala.collection.mutable.{ArrayBuffer, ArrayStack}
import scala.runtime.stdLibPatches.Predef.assert

class PlayerTest extends FunSuite {
  val exWeather = new WeatherCard("Sunny", "It's a beautiful day outside")
  val exCloseCombat = new CloseCombatCard("Pablo", "El mismisimo", 3)
  val exSiege = new SiegeCard("Alejandro", "No se que es asedio", 5)
  val exDistance = new DistanceCard("Felipe", "Ta muy lejos", 4)

  var baseDeck: ArrayBuffer[Card] = ArrayBuffer(exSiege, exWeather, exDistance, exCloseCombat)
  var nullPlayer: Player = new Player("",baseDeck)
  var player1: Player = new Player("", ArrayBuffer[Card]())
  var player2: Player = new Player("", baseDeck)
  var board = new Board(player1, player2)

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new Player("P1", baseDeck.map(identity))
    player2 = new Player("", baseDeck.map(identity))
    board = new Board(player1, player2)
  }

  test("equals") {
    assertEquals(player1, player1)
    assertEquals(player1, new Player("P1", baseDeck))
    assert(!player1.equals(player2))
    assert(!player1.equals(new WeatherCard("Algo","Otro algo")))
  }

  test("El jugador tiene nombre") {
    assert(player1.getName == "P1")
    assert(player2.getName != null)
    assert(player2.getName.nonEmpty)
  }

  test("El jugador tiene mazo de cartas") {
    assert(player1.getDeck.length >= 0)
    assert(player2.getDeck != null)
  }

  test("El jugador tiene mano de cartas") {
    assert(player1.getHand.length >= 0)
    assert(player2.getHand != null)
  }

  test("El jugador comienza con 2 gemas") {
    assert(player1.getGems == 2)
    val nuevoJugador = new Player("", ArrayBuffer[Card]())
    assert(nuevoJugador.getGems == 2)
  }

  test("El jugador comienza con un tablero nulo"){
    val nuevoJugador = new Player("", ArrayBuffer[Card]())
    assertEquals(nuevoJugador.getBoard, new NullBoard)
  }


/*  test("El jugador puede robar cartas del mazo"){
    var l_mano = player1.ver_mano().length
    var l_mazo = player1.ver_mazo().length
    player1.robar()
    assert(player1.ver_mazo().length == l_mazo-1)
    assert(player1.ver_mano().length == l_mano + 1)
    player1.jugar()
    assert(player1.ver_mano().length == l_mano - 1)
  }*/

  test("El jugador puede jugar cartas de su mano"){
    var len = player1.getDeck.length
    player1.drawCard(len)
    player1.playCard(player1.getHand(0))
  }
}

