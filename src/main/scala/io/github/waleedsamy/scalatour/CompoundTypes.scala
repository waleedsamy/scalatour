package io.github.waleedsamy.scalatour

object CompoundTypes extends App {

  trait Cloneable extends java.lang.Cloneable {
    override def clone(): Cloneable = super.clone().asInstanceOf[Cloneable]
  }

  trait Resetable {
    def reset: Unit
  }

  def cloneThenReset(obj: Cloneable with Resetable): Cloneable = {
    val copy = obj.clone()
    obj.reset
    copy
  }
}