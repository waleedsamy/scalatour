package de.traffics.otdsinterpreter

/**
  * http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
  */
object Math {
  trait NumberLike[T] {
    def plus(x: T, y: T): T
    def divide(x: T, y: Int): T
    def minus(x: T, y: T): T
  }
  object NumberLike {
    implicit object NumberLikeDouble extends NumberLike[Double] {
      def plus(x: Double, y: Double): Double = x + y
      def divide(x: Double, y: Int): Double = x / y
      def minus(x: Double, y: Double): Double = x - y
    }
    implicit object NumberLikeInt extends NumberLike[Int] {
      def plus(x: Int, y: Int): Int = x + y
      def divide(x: Int, y: Int): Int = x / y
      def minus(x: Int, y: Int): Int = x - y
    }
  }
}

object Statistics extends App{
  import Math.NumberLike

  def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
    ev.divide(xs.reduce(ev.plus(_,_)), xs.size)

  val numbers = Vector[Int](13, 23, 42, 45, 61, 73, 96, 100, 199, 420, 900, 3839)
  val words = Vector[String]("Hello", "world", "!")

  implicit object NumberLikeString extends NumberLike[String]{
    override def plus(x: String, y: String) = x.concat(y)
    override def minus(x: String, y: String) = x
    override def divide(x: String, y: Int): String = x.substring(y)
  }

  println(mean(numbers))
  println(mean(words))
}
