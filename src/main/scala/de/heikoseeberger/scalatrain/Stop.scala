package de.heikoseeberger.scalatrain

case class Stop(station: Station, arrivalTime: Time, departureTime:Time) {
  // TODO arrivalTime must be before departureTime
}
