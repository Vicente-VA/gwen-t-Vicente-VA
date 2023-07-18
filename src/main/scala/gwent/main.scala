package cl.uchile.dcc
package gwent

import gwent.cardCatalog.unitCards.closeCombat.{Dwarf, Knight, LinkButNowWithSword, WrenchDude}
import gwent.cardCatalog.unitCards.distance.{Decidueye, Legolas, LinkWithBow, SniperMonke}
import gwent.cardCatalog.unitCards.siege.{Ballista, Bomber, Kevin}
import gwent.cardCatalog.weatherCards.{Foggy, Rainy, Snowy, Sunny}
import gwent.definitions.card.Card

import scala.collection.mutable.ArrayBuffer


object main {
  def main(args: Array[String]): Unit = {
    val premadeDeck: ArrayBuffer[Card] = ArrayBuffer(
      new Dwarf, new Dwarf, new Knight, new Knight, new LinkButNowWithSword, new LinkButNowWithSword, new WrenchDude, new WrenchDude,
      new Legolas, new Legolas, new LinkWithBow, new LinkWithBow, new SniperMonke, new SniperMonke, new Decidueye, new Decidueye,
      new Ballista, new Bomber, new Bomber, new Kevin, new Kevin,
      new Snowy, new Rainy, new Foggy, new Sunny
    )

    println(premadeDeck.length)
  }
}