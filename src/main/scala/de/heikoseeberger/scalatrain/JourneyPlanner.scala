package de.heikoseeberger.scalatrain

class JourneyPlanner(trains: Set[Train]) extends Logging { //Set enthält keine Duplicate!
  def stations: Set[Station] = trains.flatMap(_.stations)
  def trains(station: Station): Set[Train] = trains.filter(_.stations().contains(station))
  def departuresAt(station: Station): Set[(Time, Train)] = trains.flatMap(train => train.schedule.filter(stop => stop.station == station).map(stop => (stop.departureTime, train)))
  logger.debug(f"Using these ${trains.size} trains:%n ${trains.mkString(f"%n")}")

}
