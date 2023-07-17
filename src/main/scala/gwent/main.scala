package cl.uchile.dcc
package gwent


object main {
  def main(args: Array[String]): Unit = {
    def a(int: Int): Unit = {
      println("Tu numero es " + int.toString)
    }
    println("Inserte su numero")
    a(scala.io.StdIn.readInt())
  }
}