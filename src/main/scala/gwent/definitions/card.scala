/*Reminder: Hay dos clases de carta; unidad y clima. Cada carta tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/

trait Card{
  val Nombre: String
  val Tipo: String
}

class Unidad(val Nombre: String,
             private val Clase: String,
             private val Fuerza: Int,
             private val Efecto: Option[String]) extends Card{
  val nombre = Nombre
  val Tipo = "Unidad"
  private val fuerza = Fuerza
  private val clase = Clase
  private val efecto = Efecto


}

class Clima(val Nombre: String, private val Efecto: Option[String]) extends Card{
  val nombre = Nombre
  val Tipo = "Clima"
  private val efecto = Efecto
}