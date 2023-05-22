/*Reminder: Hay dos clases de carta; unidad y clima. Cada carta tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/
package cl.uchile.dcc
package gwent.definitions
import scala.collection.mutable

trait CartaTrait{
  protected var Nombre: String
  protected val Tipo: String
  def ver_nombre(): String
  def ver_tipo(): String
}

/** Carta abstracta, que define nombre y tipo.
 *
 *  @constructor crea una carta con nombre y tipo.
 *  @param nombre es el nombre que se muestra de la carta.
 *  @param tipo es el tipo de la carta. puede ser Unidad o Clima.
 */
abstract class Carta(protected val nombre: String, val tipo: String) extends CartaTrait{
  protected var Nombre: String = nombre
  protected val Tipo: String = tipo
  if (this.Nombre == ""){
    this.Nombre = "Cartita"
  }
  def ver_nombre(): String = {
    this.Nombre
  }
  def ver_tipo(): String = {
    this.Tipo
  }
}

/** Unidad, carta jugable en el campo
 *
 *  @constructor crea una unidad con nombre, clase, fuerza. puede incluir ademas un efecto especial.
 *  @param clase es la clase de la carta que define donde puede ser jugada. puede ser CaC, Distancia o Asedio.
 *  @param fuerza es la fuerza de la carta, expresada en un valor entero mayor o igual a 0.
 *  @param efecto es un efecto especial que puede o no tener la carta.
 */
class Unidad(nombre: String,
             private val clase: String,
             private var fuerza: Int,
             private val efecto: Option[String]) extends Carta(nombre,"Unidad"){
  private var Fuerza = fuerza
  private var Clase = clase
  private val Efecto = efecto
  if (this.Fuerza < 0){
    this.Fuerza = 0
  }
  if (!List("CaC","Distancia","Asedio").contains(this.Clase)){
    this.Clase = "CaC"
  }
  private def canEqual(that: Any): Boolean = that.isInstanceOf[Unidad]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Unidad]
      (this eq other) ||
        (this.Nombre == other.Nombre &&
          this.Fuerza == other.Fuerza &&
          this.Clase == other.Clase &&
          this.Efecto == other.Efecto)
    } else false
  }
  def ver_fuerza(): Int = {
    this.Fuerza
  }
  def ver_clase(): String = {
    this.Clase
  }
  def ver_efecto(): Option[String] = {
    this.Efecto
  }
}

/** Clima, carta jugable al centro
 *
 *  @constructor crea una carta de clima con nombre
 *  @param nombre es el nombre de la carta.
 *                es el unico valor pues el efecto que cause dependera de la carta o el campo afectado
 */
class Clima(nombre: String) extends Carta(nombre,"Clima"){
  private def canEqual(that: Any): Boolean = that.isInstanceOf[Clima]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Clima]
      (this eq other) ||
        (this.Nombre == other.Nombre)
    } else false
  }
}