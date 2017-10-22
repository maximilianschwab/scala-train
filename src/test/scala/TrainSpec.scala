import de.heikoseeberger.scalatrain.Train
import org.scalatest.{ Matchers, WordSpec }

class TrainSpec extends WordSpec with Matchers {
  "Creating a train" should {
    "throw an IllegalArgumentException for an empty kind" in {
      an[IllegalArgumentException] should be thrownBy Train("", 666)
    }
  }
}
