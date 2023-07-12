package cl.uchile.dcc
package definitions.card.unit_card

import gwent.definitions.Player
import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard}
import gwent.definitions.card.weatherCard.WeatherCard

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class CloseCombatCardTest extends FunSuite{
  val card1: CloseCombatCard = new CloseCombatCard("Pedro", "El primero", 1)
  val card2: CloseCombatCard = new CloseCombatCard("Juan", "El segundo", 2)
  val card3: WeatherCard = new WeatherCard("Sunny", "No el dulce")

  test("equals"){
    assertNotEquals(card1, card2)
    assertEquals(card1, card1)
    assertEquals(card1, new CloseCombatCard("Pedro", "El primero", 1))
    assert(!card1.equals(card3))
    assert(!card2.equals(new Player("Pablo", ArrayBuffer[Card]())))
  }
}