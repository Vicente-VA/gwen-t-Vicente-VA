/*Reminder: Un jugador debe tener Nombre, Seccion del tablero, Contador de gemas,
* Mazo de cartas y Mano de cartas*/

import scala.collection.mutable.ArrayBuffer

trait Player{
  val Nombre: String
  val Seccion: Int
  var Gemas: Int
  var Mazo: ArrayBuffer[Card]
}

class Usuario(val nombre: String, var mazo: ArrayBuffer[Card]){
  private val Nombre: String = nombre
  private val Seccion: Int = 0
  private var Gemas: Int = 2
  private var Mazo: ArrayBuffer[Card] = ArrayBuffer[Card]()
}

class COM{
  private val Nombre: String = "COM"
  private val Seccion: Int = 1
  private var Gemas: Int = 2
  private var Mazo: ArrayBuffer[Card] = ArrayBuffer[Card]()
}