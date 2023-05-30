package cl.uchile.dcc
package gwent.definitions.card.unit_card

import gwent.definitions.card.AbstractUnitCard

import cl.uchile.dcc.gwent.definitions.board.Board

class CloseCombatCard(name: String, description: String, strength: Int) extends AbstractUnitCard(name, description, strength){
  override def play(board: Board): Unit = board.playCloseCombatCard(this)
}
