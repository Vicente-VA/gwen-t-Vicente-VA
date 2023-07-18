package cl.uchile.dcc
package gwent.definitions.card.cardEffects

trait CardEffect {
  val name: String
  val targetPlayer: String
  val targetCards: String
  var applied: Boolean
}
