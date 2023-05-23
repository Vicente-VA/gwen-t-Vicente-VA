package cl.uchile.dcc
package gwent.definitions.carta

import gwent.definitions.carta.Carta

abstract class UnidadAbs(nombre: String,
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
