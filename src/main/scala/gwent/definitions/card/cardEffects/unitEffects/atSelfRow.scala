package cl.uchile.dcc
package gwent.definitions.card.cardEffects.unitEffects

import gwent.definitions.card.Card

/**
 * atSelfRow agrupa a los efectos que apuntan al jugador que las juega y actuan sobre la fila de la carta que lo activa
 * 
 * - Los efectos concretos deben definir nombre y apply()
 */
abstract class atSelfRow extends UnitCardEffect{
  val targetPlayer: String = "self"
  val targetCards: String = "row"
  var applied: Boolean = false
}
