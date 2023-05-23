package cl.uchile.dcc
package gwent.definitions.tablero

import cl.uchile.dcc.gwent.definitions.carta.{Carta, Clima, Unidad}


trait Seccion{
  var ListaCuerpoCuerpo: List[UnidadCuerpoCuerpo]
  var ListaDistancia: List[UnidadDistancia]
  var ListaAsedio: List[UnidadAsedio]
  var LugarClima: Clima
  def jugar(c: Carta): List[Carta]
}

