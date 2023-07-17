package cl.uchile.dcc
package gwent.definitions.card.cardEffects.onPlay.self.row

import gwent.definitions.card.Card
import gwent.definitions.card.cardEffects.CardEffect

class MoraleBoost extends atSelfRow {
  override val name: String = "Morale Boost"

  def apply(self: Card, target: Card): Unit = {

  }
}
