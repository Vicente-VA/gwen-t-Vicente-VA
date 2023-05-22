package cl.uchile.dcc
package gwent.definitions.tablero

import gwent.definitions.Unidad


trait Field:
  var onField: List[T]

class CuerpoCuerpoField extends Field {
  override var onField: List[Unidad] = List()

}

class AsedioField extends Field {

}

class DistanciaField extends Field {

}