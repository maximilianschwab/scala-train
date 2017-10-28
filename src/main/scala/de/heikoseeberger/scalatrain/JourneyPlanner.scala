package de.heikoseeberger.scalatrain

class JourneyPlanner(trains: Set[Train]) extends Logging { //Set enthält keine Duplicate!

  def stations: Set[Station] = trains.flatMap(_.stations)

  def trains(station: Station): Set[Train] = trains.filter(_.stations().contains(station))

  //def departuresAt(station: Station): Set[(Time, Train)] = trains.flatMap(train => train.schedule.filter(stop => stop.station == station).map(stop => (stop.departureTime, train)))
  /*def departuresAt(station: Station): Set[(Time, Train)] = for {
    train <- trains
    stop <- train.schedule if stop.station == station
  } yield (stop.departureTime, train)*/
  def departuresAt(station: Station): Set[(Time, Train)] = for {
    train <- trains
    Stop(`station`, _, departureTime) <- train.schedule
  } yield (departureTime, train)

  logger.debug(f"Using these ${trains.size} trains:%n ${trains.mkString(f"%n")}")

  def isShortTrip(from: Station, to: Station): Boolean = trains.exists {
    _.stations().dropWhile(_ != from) match {
      case Seq(`from`, _, `to`, _*) => true //From und To mit nur einem Stop erreichbar
      case Seq(`from`, `to`, _*)    => true //From und To ohne zwischenstop erreichbar
      case _                        => false
    }
  }

}
