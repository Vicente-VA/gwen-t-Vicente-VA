package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}

import scala.collection.mutable.ArrayBuffer


class Section(){
  var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

  def playCloseCombatCard(c: CloseCombatCard): Unit = {
    closeCombatField += c
  }

  def playDistanceCard(c: DistanceCard): Unit = {
    distanceField += c
  }

  def playSiegeCard(c: SiegeCard): Unit = {
    siegeField += c
  }
}
