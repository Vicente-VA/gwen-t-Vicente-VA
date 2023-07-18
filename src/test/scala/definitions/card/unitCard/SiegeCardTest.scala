package cl.uchile.dcc
package definitions.card.unitCard

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unitCard.SiegeCard
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class SiegeCardTest extends FunSuite{
  val card1: SiegeCard = new SiegeCard("Pedro", "El primero", 1)
  val card2: SiegeCard = new SiegeCard("Juan", "El segundo", 2)
  val card3: WeatherCard = new WeatherCard("Sunny", "No el dulce")

  test("equals"){
    assertNotEquals(card1, card2)
    assertEquals(card1, card1)
    assertEquals(card1, new SiegeCard("Pedro", "El primero", 1))
    assert(!card1.equals(card3))
    assert(!card2.equals(new Player("Pablo", ArrayBuffer[Card]())))
  }
}
