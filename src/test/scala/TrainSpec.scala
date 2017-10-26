import org.scalatest.{Matchers, WordSpec}

class TrainSpec extends WordSpec with Matchers {
  "Creating a train" should {
    "throw an IllegalArgumentException for an empty kind" in {
      // TODO write tests!
      //an[IllegalArgumentException] should be thrownBy Train("", 666, Seq.empty[Stop])
    }
  }
}
