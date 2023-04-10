/*Reminder: Hay dos clases de carta; unidad y clima. Cada carta tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/

import munit.FunSuite
import scala.collection.mutable.ArrayBuffer

class CardTest extends FunSuite{
  var Carta_1: Unidad = null
  var Carta_2: Clima = null

  override def beforeEach(context: BeforeEach) = {
    Carta_1 = new Unidad("Guerrero","Distancia",4,null)
    Carta_2 = new Clima("COM", null)
  }

  test("La carta tiene nombre") {

  }

  test("La carta tiene una clase, y esta puede ser 'Unidad' o 'Clima' ") {

  }

  test("La carta tiene un valor Fuerza, y este es mayor o igual a 0") {

  }

  test("La carta puede tener una habilidad especial, y puede no tenerla") {

  }

}


