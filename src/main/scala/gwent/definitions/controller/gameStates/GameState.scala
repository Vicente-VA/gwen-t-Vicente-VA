package cl.uchile.dcc
package gwent.definitions.controller.gameStates

import gwent.definitions.controller.GameController

/**
 * GameState, estados de las distintas fases del juego
 * 
 * @param context es el controlador del juego, al que se le asignan jugadores y con el que se
 *                invocan los metodos para que el jugador interactue con el juego
 */
abstract class GameState(val context: GameController){
  context.state = this
  val name: String

  /**
   * play es la funcion con la que se inicia la fase de juego de cada estado, en la que se inicializa el juego, 
   * se le hacen consultas al jugador para concretar acciones o se ejecutan las deciciones de la COM
   * 
   * @param mode es un string con el que se determina si se esta jugando o testeando. siempre que se este en
   *             una partida real se debe usar la palabra "real", mientras que los modos de testeo dependerán de la
   *             funcionalidad que se quiera probar
   */
  def play(mode: String): Unit

  /**
   * Metodo de transición a estado Inicial. Arroja error de manera predeterminada
   */
  def toBeginningState(): Unit = {
    transitionError("BeginningState")
  }

  /**
   * Metodo de transición a estado Jugador. Arroja error de manera predetermianda
   */
  def toPlayerState(): Unit = {
    transitionError("PlayerState")
  }

  /**
   * Metodo de transición a estado COM. Arroja error de manera predeterminada
   */
  def toCOMState(): Unit = {
    transitionError("COMState")
  }

  /**
   * Metodo de transición a estado Final. Arroja error de manera predeterminada
   */
  def toEndState(): Unit = {
    transitionError("EndState")
  }


  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}

class InvalidTransitionException(message: String) extends Exception(message)