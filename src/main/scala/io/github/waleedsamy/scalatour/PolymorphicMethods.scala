package io.github.waleedsamy.scalatour

object PolymorphicMethods extends App {

  def dup[T](x: T, n: Int): List[T] = {
    if (n == 0) Nil
    else x :: dup(x, n - 1)
  }

  println(dup(1, 2))
  println(dup(3, 4))
  println(dup("five", 6))

}
