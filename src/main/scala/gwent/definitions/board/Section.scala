package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, IPlayUnit, SiegeCard}

import scala.collection.mutable.ArrayBuffer


class Section() extends IPlayUnit{
  var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

  def playCloseCombatCard(c: CloseCombatCard): Boolean = {
    closeCombatField += c
    true
  }

  def playDistanceCard(c: DistanceCard): Boolean = {
    distanceField += c
    true
  }

  def playSiegeCard(c: SiegeCard): Boolean = {
    siegeField += c
    true
  }

  def getCloseCombatField: ArrayBuffer[CloseCombatCard] = this.closeCombatField.map(identity)
  def getDistanceField: ArrayBuffer[DistanceCard] = this.distanceField.map(identity)
  def getSiegeField: ArrayBuffer[SiegeCard] = this.siegeField.map(identity)
}
