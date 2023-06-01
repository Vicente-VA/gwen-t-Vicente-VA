/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas
* Ademas, sete debe poder robar cartas de su deck y jugar cartas de su mano*/
package cl.uchile.dcc
package gwent.definitions

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

import scala.collection.mutable
import munit.FunSuite

import scala.collection.mutable.{ArrayBuffer, ArrayStack}
import scala.runtime.stdLibPatches.Predef.assert

class PlayerTest extends FunSuite {
  def empty_array(): ArrayBuffer[Card] = {
    new ArrayBuffer[Card]
  }
  var mazo_inicial: ArrayBuffer[Card] = empty_array()
  var mano_inicial: ArrayBuffer[Card] = empty_array()
  var nullPlayer: Player = new Player("",empty_array(), new IBoard(nullPlayer, nullPlayer))
  var player1: Player = new Player("", empty_array(), new IBoard(player1, player1))
  var player2: Player = new Player("", empty_array(), new IBoard(player2, player2))
  var board = new IBoard(player1, player2)

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new Player("P1", empty_array(), new IBoard(player1, nullPlayer))
    player2 = new Player("", empty_array(), new IBoard(player))
    board = new IBoard(player1, player2)
  }

  test("equals") {
    assertEquals(player1, player1)
    assertEquals(player1, new Player("P1", mazo_inicial, board))
    assert(!player1.equals(player2))
    assert(!player1.equals(new WeatherCard("Algo","Otro algo")))
  }

  test("El jugador tiene name") {
    assert(player1.getName() == "P1")
    assert(player2.getName() != null)
    assert(player2.getName().nonEmpty)
  }

  test("El jugador tiene deck de cartas") {
    assert(player1.getDeck().length >= 0)
    assert(player2.getDeck() != null)
  }

  test("El jugador tiene mano de cartas") {
    assert(player1.getHand().length >= 0)
    assert(player2.getHand() != null)
  }

  test("El jugador comienza con 2 gemas") {
    assert(player1.getGems() == 2)
    val nuevoJugador = new Player("", new Array[Card](0), new IBoard())
    assert(nuevoJugador.cuanta_vida() == 2)
  }

  /*
    test("El jugador puede robar cartas del deck"){
      var l_mano = player1.ver_mano().length
      var l_mazo = player1.ver_mazo().length
      player1.robar()
      assert(player1.ver_mazo().length == l_mazo-1)
      assert(player1.ver_mano().length == l_mano + 1)
      player1.jugar()
      assert(player1.ver_mano().length == l_mano - 1)
    }

    test("El jugador puede jugar cartas de su mano"){

    }
  */

}

