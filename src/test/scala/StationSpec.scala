package de.heikoseeberger.scalatrain

import org.scalatest.{ Matchers, WordSpec }

class StationSpec extends WordSpec with Matchers {
  "Creating a station" should {
    "throw an IllegalArgumentException for an empty name" in {
      an[IllegalArgumentException] should be thrownBy Station("")
    }
  }
}
