/*Reminder: Un jugador debe tener Nombre, Seccion del tablero, Contador de gemas,
* Mazo de cartas y Mano de cartas
* Ademas, sete debe poder robar cartas de su mazo y jugar cartas de su mano*/
package cl.uchile.dcc
package gwent.definitions

import cl.uchile.dcc.gwent.definitions.card.{Card, Clima, Unidad}

import scala.collection.mutable
import munit.FunSuite

import scala.collection.mutable.{ArrayBuffer, ArrayStack}
import scala.runtime.stdLibPatches.Predef.assert

class JugadorTest extends FunSuite{
  var arr_void: Array[Card] = Array()
  var mazo_inicial: Array[Card] = Array(new Unidad("Felipe","Distancia",1, None), new Clima("Soleado"))
  var mano_inicial: Array[Card] = Array()
  var Jugador_1: Jugador = new Jugador("", arr_void,arr_void)
  var Jugador_2: Jugador = new Jugador("", arr_void,arr_void)

  override def beforeEach(context: BeforeEach): Unit ={
    Jugador_1 = new Jugador("P1", mazo_inicial, mano_inicial)
    Jugador_2 = new Jugador("", new Array[Card](0), new Array[Card](0))
  }
  test("equals"){
    assertEquals(Jugador_1, Jugador_1)
    assertEquals(Jugador_1, new Jugador("P1", mazo_inicial, mazo_inicial))
    assert(!Jugador_1.equals(Jugador_2))
    assert(!Jugador_1.equals(new Clima("A")))
  }

  test("El jugador tiene nombre"){
    assert(Jugador_1.ver_nombre() == "P1")
    assert(Jugador_2.ver_nombre() != null)
    assert(Jugador_2.ver_nombre().nonEmpty)
  }

  test("El jugador tiene mazo de cartas"){
    assert(Jugador_1.ver_mazo().length >= 0)
    assert(Jugador_2.ver_mazo() != null)
  }

  test("El jugador tiene mano de cartas"){
    assert(Jugador_1.ver_mano().length >= 0)
    assert(Jugador_2.ver_mano() != null)
  }

  test("El jugador comienza con 2 gemas"){
    assert(Jugador_1.cuanta_vida() == 2)
    val nuevoJugador = new Jugador("", new Array[Card](0), new Array[Card](0))
    assert(nuevoJugador.cuanta_vida() == 2)
  }

/*
  test("El jugador puede robar cartas del mazo"){
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

