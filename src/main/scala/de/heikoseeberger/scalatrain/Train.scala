package de.heikoseeberger.scalatrain

//Primärkonstruktor und definition der Felder
case class Train(kind: String, number: Int) {
  //Hilfskonstruktoren bzw. Sekundärkonstruktoren
  //def this() = this(0)
  //def this(number1:Int, number2:Int) = this(number1+number2)
  //Check preconditions: kind must not be empty!
  require(kind.nonEmpty, "kind must not be empty!")
}
