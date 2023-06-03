package cl.uchile.dcc
package gwent.definitions.card.unit_card

import cl.uchile.dcc.gwent.definitions.Player

/**
 * CloseCombatCard, jugable en closeCombatField de Section
 * @param name nombre de la carta
 * @param description es una descripción de la carta. puede incluir características de alguna habilidad de la carta o
 *                     de la historia (lore) de esta.
 * @param strength    es la fuerza de la carta, expresada en un valor entero mayor o igual a 0.
 */
class CloseCombatCard(name: String, description: String, strength: Int) extends AbstractUnitCard(name, description, strength){
  override def play(player: Player): Boolean = {
    player.playCloseCombatCard(this)
  }

  def canEqual(that: Any): Boolean = {
    this.getClass.getName == that.getClass.getName
  }
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CloseCombatCard]
      (this eq other) ||
        (this.name == other.name &&
          this.strength == other.strength &&
          this.description == other.description)
    } else false
  }
}
