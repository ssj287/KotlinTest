fun main(args: Array<String>) {
    //一次赋值(只读)的局部变量
    val a:Int=1//立即赋值
    val b=2//自动推断int类型
    val c:Int//没有初始值不能省略
    c=3//明确赋值
    //可变变量
    var x=5
    x+=1
    //使用字符串模板
    var a1=1
    //模板的简单名称
    val s1="a1 is $a1"
    a1=2
    //模板的任意表达式
    val s2="${s1.replace("is","was")},but now is $a1"
    println("a:"+a)
    println("x:"+x)
    println(s1)
    println(s2)
    println(maxOf(a,b))
    println("测试可空值:"+printProdoct("as","das"))
    println("测试长度:"+getStringLength("das"))
}