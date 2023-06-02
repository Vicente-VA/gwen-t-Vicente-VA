package cl.uchile.dcc
package gwent.definitions.card.weatherCard

trait IPlayWeather {
  def playWeatherCard(c: WeatherCard): Boolean
}
