/******apply，unapply，unapplySeq等方法的使用*****/
//apply方法一般用于伴生对象中，用来简化对象定的创建，在创建对象时，可以省去new关键字
class ApplyDemo(val name:String,var age:Int){
  def update(name:String,age:Int){   //定义update函数
    println("change age")
    this.age = age
  }
}

object ApplyDemo{
  def apply(name:String,age:Int):ApplyDemo = {   //定义apply方法
    new ApplyDemo(name,age)
  }

  def unapply(demo:ApplyDemo):Option[(String,Int)]={
    if(demo.name==null) None else Some((demo.name,demo.age))
  }
}


//unapply也可以不用提取自定义对象里的属性，也可用于提取字符串
//定义一个object用于提取name里的姓氏和名字
object Name{
  def unapply(name:String)={
    val pos = name.indexOf(" ")
    if (pos == -1){
      None
    }else{
      Some((name.substring(0,pos),name.substring(pos+1)))
    }
  }
}

object Test{
  def main(args: Array[String]):Unit={
    val d1 = ApplyDemo("zhangsan",18)    //省略new关键字创建对象。等价于d1.apply("zhangsan",18)
    val d2 = new ApplyDemo("lisi",20)
    println(d1.name,d1.age)
    println(d2.name,d2.age)
    d1.update("zhangsan",19)     //x.update(y,z) == x(y) = z
    d2("lisi") = 21         //等价于d2.update("lisi",21)
    println(d1.name,d1.age)
    println(d2.name,d2.age)

    val ApplyDemo(name,age) = d1      //通过name和age两个变量提取出d1对象里的name和age属性值
    println("name = "+name,"age = " + age)

    val author = "Cay Horstman"
    val Name(first,last) = author
    println(first,last)
  }
}
