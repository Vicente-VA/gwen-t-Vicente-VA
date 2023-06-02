package cl.uchile.dcc
package gwent.definitions.card.unit_card

import cl.uchile.dcc.gwent.definitions.Player

class DistanceCard(name: String, description: String, strength: Int) extends AbstractUnitCard(name, description, strength){
  override def play(player: Player): Boolean = {
    player.playDistanceCard(this)
  }

  def canEqual(that: Any): Boolean = {
    this.getClass.getName == that.getClass.getName
  }
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[DistanceCard]
      (this eq other) ||
        (this.name == other.name &&
          this.strength == other.strength &&
          this.description == other.description)
    } else false
  }
}
