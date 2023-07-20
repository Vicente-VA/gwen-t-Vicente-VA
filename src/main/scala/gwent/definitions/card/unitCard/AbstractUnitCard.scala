package cl.uchile.dcc
package gwent.definitions.card.unitCard

import gwent.definitions.card.Card

import cl.uchile.dcc.gwent.definitions.Player
import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.{NullUnitEffect, UnitCardEffect}
import cl.uchile.dcc.gwent.definitions.controller.notifications.deadPlayerNotification


/** AbstractUnitCard: Clase abstracta para las cartas de unidad
 *
 *  @constructor crea una unidad con name, fuerza. puede incluir ademas un efecto especial.
 *  @param strength    es la fuerza de la carta, expresada en un valor entero mayor o igual a 0.
 *  @param description es una descripción de la carta. puede incluir características de alguna habilidad de la carta o
 *                     de la historia (lore) de esta.
 */
abstract class AbstractUnitCard protected(val name: String, val description: String,
                                          val strength: Int) extends UnitCard {
  private var currentStrength: Int = this.strength
  private var baseStrength: Int = this.strength
  if (this.currentStrength < 0) {
    this.currentStrength = 0
  }

  override val effect: UnitCardEffect = new NullUnitEffect()

  def getStrength: Int = {
    this.currentStrength
  }
  def getBaseStrength: Int = {
    this.baseStrength
  }
  def getName: String = {
    this.name
  }

  def setStrength(int: Int): Unit ={
    if (int > 0) {
      currentStrength = int
    }
    else {
      currentStrength = 0
    }
  }

  def setBaseStrength(int: Int): Unit = {
    setStrength(int)
    if (int > 0) {
      baseStrength = int
    }
    else {
      baseStrength = 0
    }
  }
}