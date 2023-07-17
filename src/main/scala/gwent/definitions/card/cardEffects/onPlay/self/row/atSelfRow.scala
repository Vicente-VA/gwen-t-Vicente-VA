package cl.uchile.dcc
package gwent.definitions.card.cardEffects.onPlay.self.row

import gwent.definitions.card.cardEffects.CardEffect

import cl.uchile.dcc.gwent.definitions.card.Card

/**
 * atSelfRow agrupa a los efectos que apuntan al jugador que las juega y actuan sobre la fila de la carta que lo activa
 * 
 * - Los efectos concretos deben definir nombre y apply()
 */
abstract class atSelfRow extends CardEffect{
  val targetPlayer: String = "self"
  val targetCards: String = "row"
  var applied: Boolean = false
}
