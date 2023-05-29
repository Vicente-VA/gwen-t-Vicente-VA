package cl.uchile.dcc
package gwent.definitions.board

import gwent.definitions.card.WeatherCard

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}

import scala.collection.mutable

trait TableroTrait{
  var weatherSection: WeatherCard
  val playerSections: mutable.Map[Player,Section]
  def playWeatherCard(c: WeatherCard): Unit
  def playCloseCombatCard(p: Player, c: CloseCombatCard): Unit
  def playDistanceCard(p: Player, c: DistanceCard): Unit
  def playSiegeCard(p: Player, c: SiegeCard): Unit
}

class Tablero(P1: Player, P2: Player) extends TableroTrait{
  var weatherSection: WeatherCard = WeatherCard("Clear","")
  val playerSections: mutable.Map[Player,Section] = mutable.Map(
    P1 -> new Section(),
    P2 -> new Section()
  )

  def playWeatherCard(c: WeatherCard): Unit = {
    weatherSection = c
  }

  def playCloseCombatCard(player: Player, card: CloseCombatCard): Unit = {
    playerSections(player).playCloseCombatCard(card)
  }

  def playDistanceCard(player: Player, card: DistanceCard): Unit = {
    playerSections(player).playDistanceCard(card)
  }

  def playSiegeCard(player: Player, card: SiegeCard): Unit = {
    playerSections(player).playSiegeCard(card)
  }
}