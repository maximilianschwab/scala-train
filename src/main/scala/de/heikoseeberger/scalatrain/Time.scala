package de.heikoseeberger.scalatrain

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {
  // TODO Check preconditions: hours must be within [0,24]!
  // TODO Check preconditions: minutes must be within [0, 60]!
  require(hours >= 0 && hours < 24, "hours must be withing [0, 24)!")
  require(minutes >= 0 && minutes < 60, "minutes must be within[0, 60)!")

  //Methoden
  def -(that: Time): Int = {
    def asMinutes(time: Time) = time.hours * 60 + time.minutes
    asMinutes(this) - asMinutes(that)
  }

  override def toString = f"$hours%02d:$minutes%02d"

  override def compare(that: Time) = this - that
}

//Companion object der Klasse Time und Sigleton Object
object Time {
  //Fabrikmethode (wäre in Java als static Methode zu definieren)
  def fromMinutes(minutes: Int): Time = {
    new Time(minutes / 60, minutes % 60)
  }

  def isIncreasing(times:Seq[Time]):Boolean = times.sliding(2).forall(times => times.size < 2 || times.head < times.last)
}
