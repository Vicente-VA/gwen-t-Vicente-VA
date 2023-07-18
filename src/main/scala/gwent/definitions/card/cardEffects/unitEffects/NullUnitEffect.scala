package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects
import gwent.definitions.card.unitCard.UnitCard

class NullUnitEffect extends UnitCardEffect {
  def apply(self: UnitCard, target: UnitCard): Unit = {}

  val name: String = ""
  val targetPlayer: String = ""
  val targetCards: String = ""
  var applied: Boolean = true
}
