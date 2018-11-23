object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val nums = Array(1,2,3,4,5,6,7,8,9,10)
    val result = for (elem <- nums if elem %2==0) yield 2*elem
    for (a <- result){
      println(a)
    }
  }
}

class Counter {
  private var value = 0
  def increment(){
    value += 1
  }
  def current() = value
}

val myCounter = new Counter()
myCounter.increment()
println(myCounter.current())
