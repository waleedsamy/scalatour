package io.github.waleedsamy.scalatour.Futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{ Failure, Success }

object FuturesWithOnComplete extends App {

  /**
   * In the event that multiple callbacks are registered on the future,
   * the order in which they are executed is not defined.
   * In fact, the callbacks may be executed concurrently with one another.
   * However, a particular ExecutionContext implementation may result in a well-defined order
   */

  val rateQuote = Future {
    3.1
  }

  def isProfitable(quota: Double) = if (quota > 3) true else false

  def buy(amount: Double, quota: Double) = amount

  rateQuote onComplete {
    case Success(quota) =>
      val purchase: Future[Double] = Future {
        if (isProfitable(quota)) buy(4, quota)
        else throw new Exception("not profitable")
      }
      purchase onComplete {
        case Success(amount) => println(s"Purchased $amount USD")
        case Failure(t) => println(s"No purchase $t")
      }

    case Failure(t) => throw t
  }

}
