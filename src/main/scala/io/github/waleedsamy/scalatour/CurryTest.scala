package io.github.waleedsamy.scalatour

object CurryTest extends App {

  def filter(xs: List[Int], f: Int => Boolean): List[Int] = {
    if (xs.isEmpty) xs
    else if (f(xs.head)) xs.head :: filter(xs.tail, f)
    else filter(xs.tail, f)
  }

  def modN(x: Int)(y: Int): Boolean = ((y % x) == 0)

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))

}
