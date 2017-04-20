package io.github.waleedsamy.scalatour

object ImplicitParameters extends App {

  trait Printer[T] {
    def print(t: T): String
  }

  implicit val sp: Printer[Int] = new Printer[Int] {
    override def print(t: Int): String = t.toString
  }

  def foo(i: Int)(implicit p: Printer[Int]) = p.print(i)

  def boo(i: Boolean)(implicit p: Printer[Boolean]) = p.print(i)

  println(foo(3))

  // compile error
  // println(boo(false))

  trait Resolver[T, R] {
    def resolve(t: T): R
  }

  object Resolver {

    implicit val ir: Resolver[Int, Boolean] = new Resolver[Int, Boolean] {
      def resolve(i: Int): Boolean = {
        if (i > 1) true
        else false
      }
    }

    implicit val sr: Resolver[String, Boolean] = new Resolver[String, Boolean] {
      def resolve(t: String): Boolean = {
        if (t.isEmpty) false
        else true
      }
    }
  }

  def foo[T, R](t: T)(implicit p: Resolver[T, R]): R = p.resolve(t)

  val i: Boolean = foo(3)
  val s: Boolean = foo("ww")

  println(s"foo(1) -> $i \nfoo('ww') -> $s")
}

