def attemptSomething(): Unit =
  println("so far, so good")
  println("still there")
  throw RuntimeException("We can't continue")
  println("you will never see this")


val i = "3".toInt

attemptSomething()