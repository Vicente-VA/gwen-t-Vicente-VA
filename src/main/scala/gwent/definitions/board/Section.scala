package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import scala.collection.mutable.ArrayBuffer


trait SectionTrait{
  var closeCombatField: ArrayBuffer[CloseCombatCard]
  var distanceField: ArrayBuffer[DistanceCard]
  var siegeField: ArrayBuffer[SiegeCard]
  def playCloseCombatCard(c: CloseCombatCard): Unit
  def playDistanceCard(c: DistanceCard): Unit
  def playSiegeCard(SiegeCard: SiegeCard): Unit
}

class Section() extends SectionTrait {
  var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

  override def playCloseCombatCard(c: CloseCombatCard): Unit = {
    closeCombatField += c
  }

  override def playDistanceCard(c: DistanceCard): Unit = {
    distanceField += c
  }

  override def playSiegeCard(c: SiegeCard): Unit = {
    siegeField += c
  }
}
