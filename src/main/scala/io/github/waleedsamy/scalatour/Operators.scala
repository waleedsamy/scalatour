package io.github.waleedsamy.scalatour

object Operators extends App {

  case class mBoolean(x: Boolean) {

    def and(that: mBoolean): mBoolean = if (x) that else this

    def or(that: mBoolean): mBoolean = if (x) this else that

    def negate: mBoolean = mBoolean(!x)

    def not(b: mBoolean) = b.negate

    def xor(that: mBoolean): mBoolean = (this or that) and not(this and that)

  }

  val t = mBoolean(true)
  val f = mBoolean(false)

  assert(t.and(t) == t)
  assert((t and t) == t)

  assert(t.or(f) == t)
  assert((t or f) == t)

  assert(f.or(t) == t)
  assert((f or t) == t)

  assert(t.negate == f)
  assert((t negate) == f)

  assert(t.xor(f) == t.xor(f))
  assert(f.xor(t) == f.xor(t))
}
