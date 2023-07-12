/*Reminder: Hay dos clases de card; unidad y clima. Cada card tiene una posicion en el mapa donde puede
* ser colocada. Las cartas de unidad se pueden colocar en las zonas de CaC, Distancia o Asedio dependiendo
* del tipo que sea*/
package cl.uchile.dcc
package definitions.card


import cl.uchile.dcc.gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard
import munit.FunSuite

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CardTest extends FunSuite {
  val exWeather = new WeatherCard("Sunny", "It's a beautiful day outside")
  val exCloseCombat = new CloseCombatCard("Pablo", "El mismisimo", 3)
  val exSiege = new SiegeCard("Alejandro", "No se que es asedio", 5)
  val exDistance = new DistanceCard("Felipe", "Ta muy lejos", 4)

  override def beforeEach(context: BeforeEach): Unit = {
    val exWeather = new WeatherCard("Sunny", "It's a beautiful day outside")
    val exCloseCombat = new CloseCombatCard("Pablo", "El mismisimo", 3)
    val exSiege = new SiegeCard("Alejandro", "No se que es asedio", 5)
    val exDistance = new DistanceCard("Felipe", "Ta muy lejos", 4)
  }

  test("equals") {
    assertEquals(exWeather, exWeather)
    assertEquals(exDistance, exDistance)
    assertEquals(exSiege, new SiegeCard("Alejandro", "No se que es asedio", 5))
    assert(!exSiege.equals(CloseCombatCard("Pablo","Backyardigan",1)))
    assert(!exCloseCombat.equals(new CloseCombatCard("Pablo", "El mismisimo", 4)))
    assert(!exCloseCombat.equals(exWeather))
    assert(!exWeather.equals(new WeatherCard("Bubbles","zaza")))
  }

  test("La card tiene name") {
    assert(exSiege.getName == "Alejandro")
    assert(exWeather.getName == "Sunny")
    assert(exCloseCombat.getName.nonEmpty)
  }

  test("Las cartas de unidad tienen un valor Fuerza, y este es mayor o igual a 0") {
    assert(exCloseCombat.getStrength >= 0)
    assert(new CloseCombatCard("","", -56).getStrength == 0)
  }

}


