/*****scala 单例 以及伴生类，伴生对象*******/

//采用关键字object定义一个单例对象,object使用方法几乎与class相同，但是object不能带参数

//单例对象
object Account{
  private var lastNumber = 0
  def newuniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}
//伴生类
class Person{
  private var privateAge = 0
  val id = Person.newId()    //伴生类可以访问半生对象的私有成员，同理半生对象也可以访问伴生类的私有成员
  def getId = id
  def age = privateAge
  def age_=(newAge: Int){      //要定义_=()方法，必须定义同名的=方法，比如age=和age_=
    privateAge = newAge
  }
  def addAge() = {
    privateAge +=1
    privateAge
  }
}

  //伴生对象
  object Person{
    private var id = 0
    private def newId() = {
      id += 1
      id
    }
  }


object ObjectTest{
  def main(args: Array[String]):Unit={
    println(Account.newuniqueNumber())
    println(Account.newuniqueNumber())
    println(Account.newuniqueNumber())
    val person = new Person()
    person.age = 18
    println(person.age)
    println(person.getId)   //此处不能用Person.getId,scala中不允许使用类名.方法名来调用，只能使用object名.方法来调用，而在object Person中没有getId方法，所以不能用Person.getId，但是在类class Person中有getId方法,所以可以用对象person来调用getId方法
    val p = new Person()
    println(p.getId)        //两次得到的id不一样，说明此处id是多有对象共享的
  }
}
