package de.heikoseeberger.scalatrain

import java.util.{ Locale, MissingResourceException, ResourceBundle }

object Labeled {

  final implicit object StationLabeled extends Labeled[Station] {
    override def label(station: Station)(implicit locale: Locale) =
      lookupLabel(s"station.${station.name}")
  }

  def label[A: Labeled](a: A)(implicit locale: Locale): String =
    implicitly[Labeled[A]].label(a)

  private def lookupLabel(key: String)(implicit locale: Locale) =
    try ResourceBundle.getBundle("labels", locale).getString(key)
    catch {
      case _: MissingResourceException => key
    }
}

trait Labeled[A] {
  def label(a: A)(implicit locale: Locale): String
}