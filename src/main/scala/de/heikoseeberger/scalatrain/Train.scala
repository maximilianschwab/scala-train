package de.heikoseeberger.scalatrain

import scala.collection.immutable.Seq
//Primärkonstruktor und definition der Felder
case class Train(info: TrainInfo, schedule: Seq[Stop]) {
  //Hilfskonstruktoren bzw. Sekundärkonstruktoren
  //def this() = this(0)
  //def this(number1:Int, number2:Int) = this(number1+number2)
  //Check preconditions: kind must not be empty!
  //require(kind.nonEmpty, "kind must not be empty!")
  require(schedule.size >= 2, "schedule must have at least two stops!")
  require(schedule.distinct == schedule, "schedule must not contain duplicate stations!")
  require(Time.isIncreasing(schedule.flatMap(stop => List(stop.arrivalTime, stop.departureTime))))

  //def station():Seq[Station] = schedule.map((stop:Stop)=>stop.station)
  //OR
  def stations(): Seq[Station] = schedule.map(_.station)
}

//Abstrakte Klasse
sealed abstract class TrainInfo {
  def number: Int
}

//Klassen ableiten
object TrainInfo {

  case class InterCityExpress(number: Int, hasWifi: Boolean = false) extends TrainInfo

  case class InterCity(number: Int) extends TrainInfo

  case class RegionalExpress(number: Int) extends TrainInfo

}