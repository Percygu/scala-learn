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


object Test{
  def main(args: Array[String]) :Unit = {
    val employee = new Employee("zhangsan",18,5000.0)
    println(employee.age)  //打印出19
    println(employee.getName)
    val agent = new SecretAgent("lisi",20)
    println(agent.getName)  //打印Hello lisi
  }
}
