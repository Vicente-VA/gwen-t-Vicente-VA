package cl.uchile.dcc
package gwent.definitions.card.unitCard

import gwent.definitions.card.Card

import cl.uchile.dcc.gwent.definitions.card.cardEffects.unitEffects.UnitCardEffect

trait UnitCard extends Card{
  val effect: UnitCardEffect
  
  def getStrength: Int
  def getBaseStrength: Int
  def setStrength(int: Int): Unit
}
