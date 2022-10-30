/**
  * Intro to loops
  */
// ranges
1 to 4
1.to(4)
(1 to 4).toList // Note end value is inclusive
(0 to 10 by 2).toList
0 until 10
(0 until 10 by 2).toList // Note: end value is exclusive
(5 until 0 by -1).toList // Note: end value is exclusive

// Factorial examples
def factorial1(n: Int) =
  (1 to n).foldLeft(1)((accum, n) => accum * n)
factorial1(5)

def factorial2(n: Int) =
  (1 to n).product
factorial2(5)

def factorial3(n: Int) =
  var acc = 1
  var i = 1
  while i < n do
    i += 1
    acc = acc * i
  acc
factorial3(5)

def factorial4(n: Int): Int =
  n match
    case 0 => 1
    case _ => n * factorial4(n - 1)
factorial4(5)


/**
 * Basketball shot example
 */
case class Position(x: Double, y: Double):
  def distanceTo(that: Position): Double = ???
  def distanceToLine(line: (Position, Position)) = ???

object Position:
  val player = Position(0, 1.80)
  val hoop = Position(6.75, 3.048)

case class Angle(radians: Double)
case class Speed(metersPerSecond: Double)

def isWinningShot(angle: Angle, speed: Speed): Boolean =
  val v0x = speed.metersPerSecond * math.cos(angle.radians)
  val v0y = speed.metersPerSecond * math.sin(angle.radians)
  val p0x = Position.player.x
  val p0y = Position.player.y
  val g = -9.81

  def goesThroughHoop(line: (Position, Position)): Boolean =
    Position.hoop.distanceToLine(line) < 0.01

  def isNotTooFar(position: Position): Boolean =
    position.y > 0 && position.x <= Position.hoop.x + 0.01

  def position(t: Int): Position =
    val x = p0x + v0x * t
    val y = p0y + v0y * t + (0.5 * g * math.pow(t, 2))
    Position(x, y)

  // main algorithm using LazyList
  val timings = LazyList.from(0)
  val positions = timings.map(position)
  val lines = positions.zip(positions.tail)
  lines
    .takeWhile((p1, _) => isNotTooFar(p1))
    .exists(goesThroughHoop)

  // main algorithm using while
  var time = 0
  var previousPosition = position(time)
  var isWinning = false
  while isNotTooFar(previousPosition) && !isWinning do
    time += 1
    val nextPostion = position(time)
    val line = (previousPosition, nextPostion)
    isWinning = goesThroughHoop(line)
    previousPosition = nextPostion
  isWinning

  // main algorithm using recursive method
  def loop(time: Int): Boolean =
    val currentPosition = position(time)
    isNotTooFar(currentPosition) match
      case true => 
        val nextPosition = position(time + 1)
        val line = (currentPosition, nextPosition)
        goesThroughHoop(line) || loop(time + 1)
      case false => false
  loop(time = 0)

end isWinningShot

val angle = Angle(1.4862)
val speed = Speed(20)
isWinningShot(angle, speed)

/**
  * Task Management example
  */
