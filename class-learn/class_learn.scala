//属性为私有的，则setter和getter方法也是私有的，属性为共有，则setter和getter方法也是共有的
class Person{
  var age = 0//定义一个公有字段
}

val p = new Person()

p.age = 20   //调用默认的公有setter方法，等用于p.age_=(20)

println(p.age) //调用默认的公有getter方法，等同于p.age()

p.age = 30

println(p.age)

p.age_=(50)

println(p.age)

//重新定义setter方法
p.age = 40

println(p.age)

class Student {
  private var privateAge = 0 //定义个私有字段
  def age = privateAge   //相当于自定义getter方法，返回私有属性privateAge,但是自定义的getter方法不能跟默认的getter方法age同名
  def age_=(newAge: Int){  //相当于自定义setter方法，用于给privateAge赋值，但是自定义的setter方法不能跟默认的setter方法age_=同名
    if (newAge > privateAge){
      privateAge = newAge
    }
  }
}

val student = new Student()
student.age = 30
student.age = 20
println("student's age is:",student.age)


class Message{
  val timeStamp = new java.util.Date
}

val message = new Message()
println(message.timeStamp)


//主构造器函数
class Person1(val name: String){
  var age = 0
  println("beginning!")  //定义在类体里的代码，在创建对象的时候都会被执行
  def this(name: String,age: Int){   //辅助构造函数
    this(name)  //  调用主构造函数
    this.age = age
  }
  def description = name + "is" + age + "years old"
}

val person = new Person1("zhangsan")   //调用主构造函数
println(person.description)

val pn = new Person1("lisi",18)  //调用辅助构造函数
println(pn.description)



/************内部类**************/
