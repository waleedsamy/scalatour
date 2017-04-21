package io.github.waleedsamy.scalatour.Futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{ Failure, Success }

object FutureWithFlatMap extends App {

  def isProfitable(x: Double, y: Double) = if (x > y) true else false

  def buy(amount: Double, quota: Double): Future[Double] = Future { amount }

  val usdQuote = Future { 3.1 }

  val chfQuote = Future { 1.9 }

  val purchase: Future[Double] = usdQuote.flatMap { usd =>
    chfQuote.withFilter(chf => isProfitable(usd, chf)).flatMap {
      chf => buy(4, chf)
    }
  }

  purchase onComplete {
    case Success(e) => println(s"$e is purchase")
    case Failure(t) => println(s"$t")
  }

}
