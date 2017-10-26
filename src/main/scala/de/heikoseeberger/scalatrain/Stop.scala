package de.heikoseeberger.scalatrain

case class Stop(station: Station, arrivalTime: Time, departureTime: Time) {
  require(arrivalTime < departureTime, "arrivalTime must be before departureTime!")
}
