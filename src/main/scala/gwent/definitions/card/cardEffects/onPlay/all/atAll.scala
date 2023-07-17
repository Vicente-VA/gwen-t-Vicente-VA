package cl.uchile.dcc
package gwent.definitions.card.cardEffects.onPlay.all

import gwent.definitions.card.cardEffects.CardEffect

import cl.uchile.dcc.gwent.definitions.card.Card

abstract class atAll extends CardEffect{
  val targetPlayer: String = "all"
  val targetCards: String = "section"
  var applied: Boolean = false
}
