package cl.uchile.dcc
package gwent.definitions.card

import gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}

import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

trait PlayCard {
  def playCloseCombatCard(card: CloseCombatCard): Unit
  def playDistanceCard(card: DistanceCard): Unit
  def playSiegeCard(card: SiegeCard): Unit
  def playWeatherCard(card: WeatherCard): Unit
}
