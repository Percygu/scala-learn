import scala.io.Source
/*****scala文件处理*****
 * **/
object FileRegex{
  def main(args: Array[String]):Unit={
    val filesource = Source.fromFile("./testFile.txt","UTF-8")
    val lines = filesource.getLines.toArray    //将文件内容放入数组
    println(lines.length)
    for(line <- lines) println(line)

    val lineIterator = filesource.getLines     //因为前面已经调用同样的方法读取过一次，所以这里读取不到
    for(l <- lineIterator){         //按行处理文件
      println(l)
    }


    val context = filesource.mkString          //将文件内容读取城一个字符串
    println(context)
    filesource.close()
  }
}
