package de.heikoseeberger.scalatrain

case class Station(name: String) {
  require(name.nonEmpty, "kind must not be empty!")

}
