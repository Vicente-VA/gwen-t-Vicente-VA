package cl.uchile.dcc
package definitions.card.unitCard

import gwent.definitions.Player
import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.{DistanceCard, SiegeCard}
import gwent.definitions.card.weatherCard.WeatherCard

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DistanceCardTest extends FunSuite{
  val card1: DistanceCard = new DistanceCard("Pedro", "El primero", 1)
  val card2: DistanceCard = new DistanceCard("Juan", "El segundo", 2)
  val card3: WeatherCard = new WeatherCard("Sunny", "No el dulce")

  test("equals"){
    assertNotEquals(card1, card2)
    assertEquals(card1, card1)
    assertEquals(card1, new DistanceCard("Pedro", "El primero", 1))
    assert(!card1.equals(card3))
    assert(!card2.equals(new Player("Pablo", ArrayBuffer[Card]())))
  }
}
