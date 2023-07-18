package cl.uchile.dcc
package gwent.definitions.card.unitCard

import gwent.definitions.Player

import cl.uchile.dcc.gwent.definitions.card.Card
import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.UnitCardEffect

/** PlayUnit, interfaz para modelar los tipos de unidad
 *  Implementa los metodos necesarios para el Double Dispatch de las posibles cartas a jugar
 *  Se retornan booleanos para analisis de casos borde y evitar el uso de excepciones
 */
trait PlayUnit {
  /** Juega una carta de tipo CloseCombatCard por medio de la implementacion de la clase concreta
   *
   * @param card es la carta jugada
   * @return la implementacion de esta funcion en la clase que la implementa,
   *         con true si la carta se pudo jugar o false si no se jugo exitosamente
   */
  def playCloseCombatCard(card: CloseCombatCard): Boolean

  /** Juega una carta de tipo DistanceCard por medio de la implementacion de la clase concreta
   *
   * @param card es la carta jugada
   * @return la implementacion de esta funcion en la clase que la implementa,
   *         con true si la carta se pudo jugar o false si no se jugo exitosamente
   */
  def playDistanceCard(card: DistanceCard): Boolean

  /** Juega una carta de tipo SiegeCard por medio de la implementacion de la clase concreta
   *
   * @param card es la carta jugada
   * @return la implementacion de esta funcion en la clase que la implementa,
   *         con true si la carta se pudo jugar o false si no se jugo exitosamente
   */
  def playSiegeCard(card: SiegeCard): Boolean
}
