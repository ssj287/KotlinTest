fun main(args: Array<String>) {
//数组
val asc=Array(5,{i->(i*i)})
println(asc[2])

//原生类型数组
val x2:IntArray= intArrayOf(1,2,3)
x2[0]=x2[1]+x2[2]
println(x2[0])

//字符串
val s="Hello world\n"
val text="""
        |for(c in "foo")
        |print(c)
""".trimMargin()//消除前导空格
println(text)
}