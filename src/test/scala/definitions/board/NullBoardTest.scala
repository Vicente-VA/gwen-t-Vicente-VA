package cl.uchile.dcc
package definitions.board

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.{Board, IBoard, NullBoard}
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class NullBoardTest extends FunSuite{
  val exWeather = new WeatherCard("Sunny", "It's a beautiful day outside")
  val exCloseCombat = new CloseCombatCard("Pablo", "El mismisimo", 3)
  val exSiege = new SiegeCard("Alejandro", "No se que es asedio", 5)
  val exDistance = new DistanceCard("Felipe", "Ta muy lejos", 4)
  var baseDeck: ArrayBuffer[Card] = ArrayBuffer(exSiege, exWeather, exDistance, exCloseCombat)

  val nullBoard: IBoard = new NullBoard()
  val P1: Player = new Player("AA", baseDeck)
  val P2: Player = new Player("BB", ArrayBuffer[Card]())
  val validBoard: IBoard = new Board(P1, P2)

  test("equals"){
    assert(!nullBoard.equals(validBoard))
    assertEquals(nullBoard, nullBoard)
    assertEquals(nullBoard, new NullBoard)
  }

  test("No se pueden jugar cartas en un tablero nulo"){
    P1.setBoard(nullBoard)
    P1.drawCard(4)

    P1.playCard(exSiege)
    assert(P1.getHand.length == 4)

    P1.playCard(exWeather)
    assert(P1.getHand.length == 4)

    P1.playCard(exDistance)
    assert(P1.getHand.length == 4)

    P1.playCard(exCloseCombat)
    assert(P1.getHand.length == 4)

    assert(nullBoard.getWeatherSection.equals(new WeatherCard("", "")))
  }
}
