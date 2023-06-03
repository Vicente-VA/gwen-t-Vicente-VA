package cl.uchile.dcc
package definitions.card.weather_card

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.DistanceCard
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class WeatherCardTest extends FunSuite{
  val card1: WeatherCard = new WeatherCard("Sunny", "No el dulce")
  val card2: WeatherCard = new WeatherCard("Sunny", "El dulce")
  val card3: WeatherCard = new WeatherCard("Trencito", "No el dulce")
  val card4: DistanceCard = new DistanceCard("Pedro", "El primero", 1)


  test("equals"){
    assertNotEquals(card1, card2)
    assertNotEquals(card1, card3)
    assertEquals(card1, card1)
    assertEquals(card1, new WeatherCard("Sunny", "No el dulce"))
    assert(!card1.equals(card2))
    assert(!card2.equals(new Player("Pablo", ArrayBuffer[Card]())))
  }
}