package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, IPlayUnit, SiegeCard}

import scala.collection.mutable.ArrayBuffer


class Section() extends IPlayUnit{
  var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

  def playCloseCombatCard(card: CloseCombatCard): Boolean = {
    closeCombatField += card
    true
  }

  def playDistanceCard(card: DistanceCard): Boolean = {
    distanceField += card
    true
  }

  def playSiegeCard(card: SiegeCard): Boolean = {
    siegeField += card
    true
  }

  def getCloseCombatField: ArrayBuffer[CloseCombatCard] = this.closeCombatField.map(identity)
  def getDistanceField: ArrayBuffer[DistanceCard] = this.distanceField.map(identity)
  def getSiegeField: ArrayBuffer[SiegeCard] = this.siegeField.map(identity)
}
