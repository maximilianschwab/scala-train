package de.heikoseeberger.scalatrain

class JourneyPlanner(trains:Set[Train]) {//Set enthält keine Duplicate!

  def stations: Set[Station] = trains.flatMap(_.stations)
  def trains(station:Station):Set[Train] = trains.filter(_.stations().contains(station))
  def departuresAt(station:Station):Set[(Time, Train)] = trains.flatMap(train => train.schedule.filter(stop=>stop.station==station).map(stop=>(stop.departureTime, train)))
}
