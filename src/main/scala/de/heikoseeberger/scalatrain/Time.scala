package de.heikoseeberger.scalatrain

case class Time(hours: Int = 0, minutes: Int = 0) {
  // TODO Check preconditions: hours must be within [0,24]!
  // TODO Check preconditions: minutes must be within [0, 60]!

  //Methoden
  def -(that: Time): Int = {
    def asMinutes(time: Time) = time.hours * 60 + time.minutes
    asMinutes(this) - asMinutes(that)
  }
}

//Companion object der Klasse Time und Sigleton Object
object Time {
  //Fabrikmethode (wäre in Java als static Methode zu definieren)
  def fromMinutes(minutes: Int): Time = {
    new Time(minutes / 60, minutes % 60)
  }
}
