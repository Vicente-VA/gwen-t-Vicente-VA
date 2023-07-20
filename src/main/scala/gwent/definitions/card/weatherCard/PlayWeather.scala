package cl.uchile.dcc
package gwent.definitions.card.weatherCard

trait PlayWeather {
  /** Juega una carta de tipo WeatherCard por medio de la implementacion de la clase concreta
   *
   * @param card es la carta jugada
   * @return la implementacion de esta funcion en la clase que la implementa,
   *         con true si la carta se pudo jugar o false si no se jugo exitosamente
   */
  def playWeatherCard(card: WeatherCard): Boolean
}
