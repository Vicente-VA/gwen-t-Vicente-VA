package cl.uchile.dcc
package gwent.definitions.card.cardEffects.watherEffects

import gwent.definitions.card.Card
import gwent.definitions.card.unitCard.UnitCard

import cl.uchile.dcc.gwent.definitions.card.cardEffects.CardEffect
import cl.uchile.dcc.gwent.definitions.card.weatherCard.WeatherCard

/** WeatherCardEffect modela los efectos que pueden tener las cartas de clima
 *
 * - targetPlayer: all
 *
 * - targetCards: row, section, closeCombat, distance, siege
 */
trait WeatherCardEffect extends CardEffect{
  def apply(self: WeatherCard, target: UnitCard): Unit
}