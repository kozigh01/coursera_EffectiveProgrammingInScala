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
