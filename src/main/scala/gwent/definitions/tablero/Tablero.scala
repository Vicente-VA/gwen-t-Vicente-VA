package cl.uchile.dcc
package gwent.definitions.tablero

trait TableroTrait:
  var sideA: List[Field]
  var sideB: List[Field]

class Tablero extends TableroTrait{
  var sideA: List[Field] = List(new CuerpoCuerpoField(), new DistanciaField, new AsedioField)


}