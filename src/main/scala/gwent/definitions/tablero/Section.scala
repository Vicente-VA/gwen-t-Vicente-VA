package cl.uchile.dcc
package gwent.definitions.tablero

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import scala.collection.mutable.ArrayBuffer


trait SectionTrait{
  var closeCombatField: ArrayBuffer[CloseCombatCard]
  var distanceField: ArrayBuffer[DistanceCard]
  var siegeField: ArrayBuffer[SiegeCard]
  def playCloseCombatCard(): Unit
  def playDistanceCard(): Unit
  def playSiegeCard(): Unit
}

class Section extends SectionTrait {
  var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

}