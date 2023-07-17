package cl.uchile.dcc
package gwent.definitions.board

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.cardEffects.CardEffect
import cl.uchile.dcc.gwent.definitions.card.unitCard.{CloseCombatCard, DistanceCard, IPlayUnit, SiegeCard}

import scala.collection.mutable.ArrayBuffer


//noinspection DuplicatedCode
class Section() extends IPlayUnit{
  private var closeCombatField: ArrayBuffer[CloseCombatCard] = ArrayBuffer()
  private var distanceField: ArrayBuffer[DistanceCard] = ArrayBuffer()
  private var siegeField: ArrayBuffer[SiegeCard] = ArrayBuffer()

  def playCloseCombatCard(card: CloseCombatCard): Boolean = {
    applyCloseCombatEffect(card)
    closeCombatField += card
    true
  }
  def playDistanceCard(card: DistanceCard): Boolean = {
    applyDistanceEffect(card)
    distanceField += card
    true
  }
  def playSiegeCard(card: SiegeCard): Boolean = {
    applySiegeEffect(card)
    siegeField += card
    true
  }

  def applyEffect(card: Card): Unit = {
    card.effect.targetCards match {
      case "section" =>
        for (target <- closeCombatField) card.effect(card, target)
        for (target <- distanceField) card.effect(card, target)
        for (target <- siegeField) card.effect(card, target)

      case "closeCombat" =>
        for (target <- closeCombatField) card.effect(card, target)

      case "distance" =>
        for (target <- distanceField) card.effect(card, target)

      case "siege" =>
        for (target <- siegeField) card.effect(card, target)

      case _ =>
    }
  }

  private def applyCloseCombatEffect(card: CloseCombatCard): Unit = {
    if (card.effect.targetCards == "row"){
      for (targetCard <- closeCombatField){
        card.effect(card, targetCard)
      }
    } else applyEffect(card)
  }

  private def applyDistanceEffect(card: DistanceCard): Unit = {
    if (card.effect.targetCards == "row") {
      for (targetCard <- distanceField) {
        card.effect(card, targetCard)
      }
    } else applyEffect(card)
  }

  private def applySiegeEffect(card: SiegeCard): Unit = {
    if (card.effect.targetCards == "row") {
      for (targetCard <- siegeField) {
        card.effect(card, targetCard)
      }
    } else applyEffect(card)
  }

  def getCloseCombatField: ArrayBuffer[CloseCombatCard] = this.closeCombatField.map(identity)
  def getDistanceField: ArrayBuffer[DistanceCard] = this.distanceField.map(identity)
  def getSiegeField: ArrayBuffer[SiegeCard] = this.siegeField.map(identity)
}
