/*Reminder: Un jugador debe tener Nombre, Seccion del tablero, Contador de gemas,
* Mazo de cartas y Mano de cartas
* Ademas, sete debe poder robar cartas de su mazo y jugar cartas de su mano*/

import munit.FunSuite
import scala.collection.mutable.ArrayBuffer
import scala.runtime.stdLibPatches.Predef.assert

class PlayerTest extends FunSuite{
  var Jugador_1: Usuario = null
  var Jugador_2: Usuario = null
  var Computadora: COM = null
  var mazo_inicial: ArrayBuffer[Card] = ArrayBuffer(Unidad(null,null,0,null), Clima(null,null))

  override def beforeEach(context: BeforeEach) ={
    Jugador_1 = new Usuario("P1", mazo_inicial)
    Jugador_2 = new Usuario(null,null)
    Computadora = new COM
  }
  test("El jugador tiene nombre"){
    assert(Jugador_1.ver_nombre() == "P1")
    assert(Jugador_2.ver_nombre() != null)
    assert(Computadora.ver_nombre() == "COM")
  }

  test("El jugador tiene mazo de cartas"){
    assert(Jugador_1.ver_mazo().length >= 0)
    assert(Jugador_2.ver_mazo() != null)
    assert(Computadora.ver_mazo().length >= 0)
  }

  test("El jugador tiene mano de cartas"){
    assert(Jugador_1.ver_mano().length >= 0)
    assert(Jugador_2.ver_mano() != null)
    assert(Computadora.ver_mano().length >= 0)
  }

  test("El jugador comienza con 2 gemas"){
    assert(Jugador_1.cuanta_vida() == 2)
    assert(Computadora.cuanta_vida() == 2)
  }

  test("El jugador puede robar cartas del mazo"){
    var l_mano = Jugador_1.ver_mano().length
    var l_mazo = Jugador_1.ver_mazo().length
    Jugador_1.robar()
    Jugador_1.jugar()
    assert(Jugador_1.ver_mano().length == l_mano+1)
    assert(Jugador_1.ver_mazo().length == l_mazo-1)
  }

  test("El jugador puede jugar cartas de su mano"){

  }
}

