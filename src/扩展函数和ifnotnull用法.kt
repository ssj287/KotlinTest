import java.io.File
fun main(args: Array<String>) {
//扩展函数
println("Convert this to camelcase".spaceToCamelCase())
//if not null 编写
val files= File("Test").listFiles()
println(files?.size)
//if not null else
var files1= File("Test").listFiles()
println(files1?.size?:"Empty")
}