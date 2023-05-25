/*Reminder: Hay dos clases de card; unidad y clima. Cada card tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/
package cl.uchile.dcc
package gwent.definitions
import cl.uchile.dcc.gwent.definitions.card.{Clima, Unidad}

import scala.collection.mutable
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class CartaTest extends FunSuite{
  var Carta_1: Unidad = _
  var Carta_2: Clima = _
  var Carta_3: Clima = _
  var Carta_4: Unidad = _

  override def beforeEach(context: BeforeEach): Unit = {
    Carta_1 = new Unidad("Guerrero","CaC",4,null)
    Carta_2 = new Clima("Soleado")
    Carta_3 = new Clima("")
    Carta_4 = new Unidad("","",-5,null)
  }

  test("equals"){
    assertEquals(Carta_1, Carta_1)
    assertEquals(Carta_2,Carta_2)
    assertEquals(Carta_2, new Clima("Soleado"))
    assert(!Carta_1.equals(new Clima("")))
    assert(Carta_1.equals(new Unidad("Guerrero", "CaC", 4, null)))
    assert(!Carta_2.equals(Carta_1))
    assert(!Carta_1.equals(Carta_4))
  }

  test("La card tiene nombre") {
    assert(Carta_1.ver_nombre() == "Guerrero")
    assert(Carta_2.ver_nombre() != null)
    assert(Carta_3.ver_nombre().nonEmpty)
  }

  test("La card tiene una clase, y esta puede ser 'Unidad' o 'Clima' ") {
    assert(Carta_1.ver_tipo() == "Unidad")
    assert(Carta_2.ver_tipo() == "Clima")
    assert(Carta_3.ver_tipo() == "Clima")
  }

  test("Unidad tiene un valor Fuerza, y este es mayor o igual a 0") {
    assert(Carta_1.ver_fuerza() >= 0)
    assert(Carta_4.ver_fuerza() == 0)
  }

  test("Unidad tiene clase, y puede ser CaC, Distancia o Asedio"){
    var Clases: List[String] = List("CaC", "Distancia", "Asedio")
    assert(Clases.contains(Carta_1.ver_clase()))
    assert(Clases.contains(Carta_4.ver_clase()))
  }

  test("La card puede tener una habilidad especial, y puede no tenerla") {

  }

}


