package de.heikoseeberger.scalatrain

object CommandLineApp {
  def main(args: Array[String]): Unit = {
    Time("12:00")
    TestData.journeyPlanner.connections(Station(args(0)), Station(args(1)), Time(args(2))).foreach(println) }
}