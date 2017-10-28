package de.heikoseeberger.scalatrain

import org.apache.logging.log4j.{ Logger => Log4jLogger, LogManager }

class Logger private[scalatrain] (underlying: Log4jLogger) {
  def info(message: => Any): Unit = if (underlying.isInfoEnabled) underlying.info(message)
  def debug(message: => Any): Unit = if (underlying.isDebugEnabled()) underlying.debug(message)
  //....

}

trait Logging {
  protected val logger: Logger = new Logger(LogManager.getLogger(getClass.getName))
}