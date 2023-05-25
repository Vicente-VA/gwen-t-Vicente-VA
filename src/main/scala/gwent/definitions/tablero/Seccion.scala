package cl.uchile.dcc
package gwent.definitions.tablero

import cl.uchile.dcc.gwent.definitions.card.unit_card.{CloseCombatCard, DistanceCard, SiegeCard}
import cl.uchile.dcc.gwent.definitions.card.{Card, Clima, Unidad}


trait Seccion{
  var ListaCuerpoCuerpo: List[CloseCombatCard]
  var ListaDistancia: List[DistanceCard]
  var ListaAsedio: List[SiegeCard]
  var LugarClima: Clima
  def jugar(c: Card): List[Card]
}

