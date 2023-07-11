package cl.uchile.dcc
package gwent.definitions.card.cardEffects

import gwent.definitions.card.Card
import gwent.definitions.card.cardEffects.CardEffect

class NullEffect extends CardEffect {
  override def apply(self: Card, other: Card): Unit = {

  }
}
