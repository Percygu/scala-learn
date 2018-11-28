/****scala类继承*****/

//超类
class Person(val name: String,var age: Int){
  age += 1    //超类构造函数
  def getName = name
}

//子类
class Employee(name:String,age: Int,val salary: Double) extends Person(name,age){

}

//子类重写超类字段，方法
class SecretAgent(name:String,age:Int) extends Person(name,age){
  override def getName = "Hello "+ name //重写父类方法

}

//抽象类，类中含有全部或部分没有被完整定义的方法必须以abstract关键字表示为抽象类
abstract class Person1(val name: String,val privateId:Int){
  def id: Int   //声明无参函数id，返回Int类型，抽象方法
  val age: Int   //没有被初始化，这是一个带有抽象的getter方法的抽象字段
  var phone: String   //没有被初始化，这是一个带有抽象的setter和getter方法的抽象字段
}

class Employee1(name:String,privateId:Int) extends Person1(name,privateId){
  def id = privateId  //子类重写超类的抽象方法不需要加override关键字
  val age = 16           //重写抽象超类的抽象字段
  var phone = "13382938220"    //重写抽象超类的抽象字段
}

object Test{
  def main(args: Array[String]) :Unit = {
    val employee = new Employee("zhangsan",18,5000.0)
    println(employee.age)  //打印出19
    println(employee.getName)
    val agent = new SecretAgent("lisi",20)
    println(agent.getName)  //打印Hello lisi
    val p: Person1 = new Employee1("wangwu",1)     //用超类Person1声明对象p,用子类Employee1实现对象
    println(p.age)
    println(p.id)
  }
}
