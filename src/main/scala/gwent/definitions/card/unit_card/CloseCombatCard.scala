package cl.uchile.dcc
package gwent.definitions.card.unit_card

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.board.Board

class CloseCombatCard(name: String, description: String, strength: Int) extends AbstractUnitCard(name, description, strength){
  override def play(player: Player): Unit = {
    player.playCloseCombatCard(this)
  }
}
