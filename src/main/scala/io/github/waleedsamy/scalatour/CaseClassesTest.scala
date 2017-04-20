package io.github.waleedsamy.scalatour

object CaseClassesTest extends App {

  object po {
    def even(xs: List[Int]): List[Int] =
      for {
        c <- xs if c % 2 == 0
      } yield c

    def even(ab: (Int, Int)): Boolean = ab match {
      case (a, _) if a % 2 == 0 => true
      case _ => false
    }

    println(even((1 to 10).toList))

    /**
     * computes all pairs of numbers between 0 and n-1 whose sum is equal to a given value v
     *
     */
    def sum(n: Int, v: Int): List[(Int, Int)] = {
      for {
        i <- (0 until n).toList
        j <- (i until n).toList
        if (i + j == v)
      } yield (i, j)
    }

    val result = sum(7, 4)

    result foreach println

    result filter even foreach println
  }

  object ao {

    /**
     * if object o1 (created by object, or instantiation of a class)
     * called with parameters `p1` to `pn` as o1(p1....pn)
     * then o1(p1....pn) is syntax sugar for o1.apply(p1....pn)
     *
     * if object o1 is created by object O (not a class!) (scala singleton Object) so
     * there is now way to create instance of it (it is already an object and no way to have more than one object of it)
     * in this case call o1(p1......pn) is same as calling o1.(p1......pn), the same as previous paragraph
     *
     *
     * unapply is An extractor can be thought of as a special method that reverses the effect of applying a particular object on some inputs.
     * called when pattern matching is called (case xxxx)
     */

    class G {

      def apply(x: Int, y: Int): G = {
        println("apply is called when object asked to be created")
        this
      }
    }

    object Twice {
      def apply(x: Int): Int = x * 2

      def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
    }

    val beforeApply = new G()
    val afterApply = beforeApply(3, 3)
    println(beforeApply)
    println(afterApply)

    val x = Twice(21)

    x match {
      case Twice(n) => Console.println(n)
    }

  }

  object bo {

    object Foo {

      class C {

        import C._

        private var dd = 123

        private def test() = {
          println(x)
        }

        override def toString: String = s"$dd $x"
      }

      object C {
        private val x = "xvalue"
        val y = "I'm y"

        def apply() = {
          println("O C Apply")
          val c = new C
          c.test()
          c.dd = 789
          c
        }
      }

    }

    val cInstance = Foo.C()
    println(cInstance)
  }

  object ho {

    abstract class Notification

    case class Email(sender: String, topic: String, body: String) extends Notification

    case class SMS(sourceNumber: String, message: String) extends Notification

    case class VoiceRecording(contactName: String, link: String) extends Notification

    val SPECIAL_EMAIL = "wa@mail.com"

    def showNotification(notification: Notification) = notification match {
      case Email(sender, topic, _) if sender == SPECIAL_EMAIL => println(s"Git an email form $sender with topic $topic")
      case SMS(sourceNumber, message) => println(s"Git a SMS from $sourceNumber with content $message")
      case v: VoiceRecording => println(s"VoiceRecording received $v")
      case other => println(s"Other $other")
    }

    val emailToA = Email("aa@mail.com", "How are you?", "Hi, what are you doing nowadays?")
    val emailToH = Email(SPECIAL_EMAIL, "How are you?", "Hi, what are you doing nowadays?")
    val emailToG = emailToH.copy(body = "Hi, do you like to have a trip")

    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    showNotification(emailToA)
    showNotification(emailToH)
    showNotification(emailToG)
    showNotification(someSms)
    showNotification(someVoiceRecording)
  }

  object co {
    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }

    println(matchTest(1))
    println(matchTest(2))
    println(matchTest(3))

    def matchAny(x: Any): Any = x match {
      case 1 => "one"
      case "two" => 2
      case y: Int => "scala.Int"
      case other => other.getClass
    }

    println(matchAny(1))
    println(matchAny("two"))
    println(matchAny(66))
    println(matchAny("Not"))

  }

}

