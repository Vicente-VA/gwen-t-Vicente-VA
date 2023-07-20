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
    class A {
      def foo(): Unit = {
        println("Metodo A")
      }
    }

    class B extends A{
      override def foo(): Unit = {
        println("Metodo B")
      }
    }

    val a: A = new A()
    val b: A = new B()

    a.foo()
    b.foo()
  }
}