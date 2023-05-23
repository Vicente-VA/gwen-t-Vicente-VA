package cl.uchile.dcc
package gwent.definitions.tablero

trait TableroTrait:
  var sideA: List[Seccion]
  var sideB: List[Seccion]

class Tablero extends TableroTrait{
  var sideA: List[Seccion] = List(new CuerpoCuerpoSeccion(), new DistanciaSeccion, new AsedioSeccion)


}