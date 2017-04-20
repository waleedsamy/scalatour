package io.github.waleedsamy.scalatour

object Variances extends App {

  /**
   * if container C defined as C[+A] - covariant
   * R subtype of T
   * then function that accept C[T] *could* accept C[R]
   */

  /**
   * if container C defined as C[A] - invariant
   * R subtype of T
   * then function that accept C[T] couldn't accept C[R]
   */

  /**
   * if container C defined as C[-A] - contravariant
   * R subtype of T
   * then function that accept C[R] *could* accept C[T]
   * then function that accept C[T] *couldn't* accept C[R]
   */
}
