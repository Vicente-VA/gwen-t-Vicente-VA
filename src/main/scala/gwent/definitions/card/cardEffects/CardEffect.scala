package cl.uchile.dcc
package gwent.definitions.card.cardEffects

/**
 * CardEffect, interfaz generica para los efectos que puedan tener las cartas
 * 
 * Incluye parametros name, targetPlayer, targetCards y applied
 * 
 * - name es el nombre del efecto
 * 
 * - targetPlayer es el jugador a quien pertenecen las cartas a las que se le aplica el efecto
 * y puede ser self u opponent
 * 
 * - targetCards son la cartas a las que se le aplica el efecto, y pueden ser row, section, 
 * closeCombat, distance o siege
 * 
 * - applied es un booleano que indica si el efecto ya fue aplicado al menos una vez (para que, en caso de que afecte
 * tambien a la carta que lo activa, solo se le aplique una vez)
 */
trait CardEffect {
  val name: String
  val targetPlayer: String
  val targetCards: String
  var applied: Boolean
}
