/*Reminder: Un jugador debe tener Nombre, Seccion del board, Contador de gemas,
* Mazo de cartas y Mano de cartas
* Ademas, sete debe poder robar cartas de su deck y jugar cartas de su mano*/
package cl.uchile.dcc
package gwent.definitions

import cl.uchile.dcc.gwent.definitions.card.{Card, Clima, Unidad}

import scala.collection.mutable
import munit.FunSuite

import scala.collection.mutable.{ArrayBuffer, ArrayStack}
import scala.runtime.stdLibPatches.Predef.assert

class PlayerTest extends FunSuite {
  def empty_array(): ArrayBuffer[Card] = {
    new ArrayBuffer[Card]
  }
  var mazo_inicial: ArrayBuffer[Card] = ???
  var mano_inicial: ArrayBuffer[Card] = empty_array()
  var Jugador_1: Player = new Player("", empty_array())
  var Jugador_2: Player = new Player("", empty_array())

  override def beforeEach(context: BeforeEach): Unit = {
    Jugador_1 = new Player("P1", empty_array(), empty_array())
    Jugador_2 = new Player("", empty_array())
  }

  test("equals") {
    assertEquals(Jugador_1, Jugador_1)
    assertEquals(Jugador_1, new Player("P1", mazo_inicial, mazo_inicial))
    assert(!Jugador_1.equals(Jugador_2))
    assert(!Jugador_1.equals(new Clima("A")))
  }

  test("El jugador tiene name") {
    assert(Jugador_1.ver_nombre() == "P1")
    assert(Jugador_2.ver_nombre() != null)
    assert(Jugador_2.ver_nombre().nonEmpty)
  }

  test("El jugador tiene deck de cartas") {
    assert(Jugador_1.ver_mazo().length >= 0)
    assert(Jugador_2.ver_mazo() != null)
  }

  test("El jugador tiene mano de cartas") {
    assert(Jugador_1.ver_mano().length >= 0)
    assert(Jugador_2.ver_mano() != null)
  }

  test("El jugador comienza con 2 gemas") {
    assert(Jugador_1.cuanta_vida() == 2)
    val nuevoJugador = new Player("", new Array[Card](0), new Array[Card](0))
    assert(nuevoJugador.cuanta_vida() == 2)
  }

  /*
    test("El jugador puede robar cartas del deck"){
      var l_mano = Jugador_1.ver_mano().length
      var l_mazo = Jugador_1.ver_mazo().length
      Jugador_1.robar()
      assert(Jugador_1.ver_mazo().length == l_mazo-1)
      assert(Jugador_1.ver_mano().length == l_mano + 1)
      Jugador_1.jugar()
      assert(Jugador_1.ver_mano().length == l_mano - 1)
    }

    test("El jugador puede jugar cartas de su mano"){

    }
  */

}

