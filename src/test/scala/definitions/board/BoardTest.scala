package cl.uchile.dcc
package definitions.board

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.{Board, IBoard, NullBoard}
import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class BoardTest extends FunSuite{
  var deck1: ArrayBuffer[Card] = ArrayBuffer(new WeatherCard("Soleado", "Sin nubes:)"))
  var deck2: ArrayBuffer[Card] = ArrayBuffer(new WeatherCard("Soleado", "Sin nubes:)"))
  var player1: Player = new Player("P1", deck1)
  var player2: Player = new Player("P2", deck2)
  var board: IBoard = new Board(player1, player2)
  var emptyBoard: IBoard = new NullBoard()

  override def beforeEach(context: BeforeEach): Unit = {
    var deck: ArrayBuffer[Card] = ArrayBuffer(new WeatherCard("Soleado", "Sin nubes:)"))
    var player1: Player = new Player("P1", deck1)
    var player2: Player = new Player("P2", deck2)
    var board: IBoard = new Board(player1, player2)
    var emptyBoard: IBoard = new NullBoard()
  }
  test("Un tablero debe posicionar una carta"){
    assert(board.playWeatherCard(new WeatherCard("", "")))
  }
}
