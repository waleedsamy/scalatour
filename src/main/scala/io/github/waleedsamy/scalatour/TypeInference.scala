package io.github.waleedsamy.scalatour

object TypeInference extends App {

  // does not compile
  // need to specify the return type

  // def fact(n: Int) = if (n == 0) 1 else n * fact(n - 1)

  // does not compile
  // cause `new Object` is not of type Null, which is the type of `null`

  // var obj = null
  //obj = new Object()

}
