package cl.uchile.dcc
package definitions.controller

import cl.uchile.dcc.gwent.definitions.controller.GameController
import munit.FunSuite

class GameControllerTest extends FunSuite{
  var controller: GameController = new GameController()
  controller.initialize("")

  test("El controlador debe ser capaz de transicionar entre estados"){
    assertEquals(controller.state.name, "Beginning")
    controller.toCOMState()
    assertEquals(controller.state.name, "COM")
    controller.toEndState()
    assertEquals(controller.state.name, "End")
    controller.toBeginningState()
    assertEquals(controller.state.name, "Beginning")
    controller.toPlayerState()
    assertEquals(controller.state.name, "Player")
    controller.toEndState()
    assertEquals(controller.state.name, "End")
  }

}
