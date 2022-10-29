/**
    * Lists
    */
case class AddressBook(contacts: List[Contact])
case class Contact(name: String, email: String, phoneNumbers: List[String])

val alice = Contact("Alice", "alice@alice.com", List())
val bob = Contact("Bob", "bob@bob.com", List("+41787829420"))

val addressBook = AddressBook(List(alice, bob))

val fruits = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4, 5)
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty = List()

val numberOfContacts = addressBook.contacts.size
val isAliceInContacts = addressBook.contacts.contains(alice)
val contactNames = addressBook.contacts.map(_.name)
val contactNames2 = addressBook.contacts.map(c => c.name)
val contactsWithPhone = addressBook.contacts.filter(_.phoneNumbers.nonEmpty)

val contacts1 = List(alice, bob)
val contacts1_1 = alice :: (bob :: Nil)
val contacts1_2 = Nil.::(bob).::(alice)
val carol = Contact("Carol", "carol@carol.com", List())
val contacts2 = carol :: addressBook.contacts
val contacts3 = addressBook.contacts.::(carol)
contacts2.size
carol :: addressBook.contacts
carol +: addressBook.contacts

addressBook.contacts match
  case contact :: tail => contact.name
  case Nil => "No contact"
addressBook.contacts match
  case first :: second :: Nil => second.name
  case _ => "List doesn't have two elements"

fruits.head
fruits.tail
fruits.tail.head
fruits.tail.tail.head
// fruits.tail.tail.tail.head // throws error
fruits(0)
// fruits(4) // throws error


/**
 * Functions
 */
val increment: Int => Int = 
  x =>
    val result = x + 1
    result

val add = (x: Int, y: Int) => x + y
add(1, increment(2))


/**
  * Collection Construction and Tuples
  */
import scala.collection.mutable

List.empty
mutable.ArrayBuffer.empty
Map.empty

val listEmpty = List.empty[Int]
val arrayBfferEmpty = mutable.ArrayBuffer.empty[Double]
val mapEmpty = Map.empty[String, Boolean]

val list1 = List(1,2,3,4)
val arrayBuffer1 = mutable.ArrayBuffer("a","b","c")
val tuple1 = ("a",true)
val tuple2 = "b" -> false
val map1 = Map(tuple1, tuple2, "c" -> false)
tuple1(0)
tuple1(1)
val (k, v) = tuple1
tuple1 match
  case (k, v) => s"tuple 1: k = '$k', v = $v"

//  Adding elements to front/back of collection
val list2 = 0 +: list1 :+ 5
list1
"0" +: arrayBuffer1 :+ "d"
arrayBuffer1
val map2 = map1 + ("d" -> true)
map1


/**
  * Querying Collections and Option
  *   Many more than those shown see: https://www.scala-lang.org/api/3.2.0/scala/collection/immutable.html
  */
val list1_2 = List(1,2,3,4,5)
list1_2.isEmpty
list1_2.nonEmpty
list1_2.find(x => x % 2 == 0)
list1_2.findLast(x => x %2 == 0)
list1_2.filter(x => x % 2 == 0)
list1_2.contains(4)
list1_2.contains(33)
list1_2.last

// option
list1_2.find(x => x % 2 == 0) match
  case Some(x) => s"Found the element = $x"
  case None => "Didn't find the element"
list1_2.find(x => x == 33) match
  case Some(x) => s"Found the element = $x"
  case None => "Didn't find the element"


/**
  * Transforming Collections
  */
val list1_3 = List(1,2,3,4)
list1_3.map(x => x + 1)
list1_3
val ab1_3 = mutable.ArrayBuffer(1,2,3,4)
ab1_3.map(x => x %2 == 0)
ab1_3
val map1_3 =Map(0 -> "No", 1 -> "Yes")
map1_3.map((k,v) => k -> (v * 2))
map1_3
