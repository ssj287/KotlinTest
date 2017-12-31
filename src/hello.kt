import javafx.scene.Parent
import jdk.internal.util.xml.impl.Attrs
import sun.text.resources.cldr.om.FormatData_om
import java.io.File
import java.lang.IllegalStateException
import javax.naming.Context
import javax.swing.text.View

//定义包位于头文件顶部

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
    val items= listOf("apple","banana","kiwi")
    println("输出列表")
    for(item in items){
        println("*"+item)
    }
    //指数
    for(index in items.indices){
        println("item at $index is ${items[index]}")
    }
    println("定指向:"+describle("Hello"))
    //使用区间
    //in检测是否在区间内
    val x1=10
    val y1=9
    if(x1 in 1..y1 ){
        println("在这个区间")
    }else{
        println("不在这个区间")
    }
    //检测某个数字是否在某个区间外
    val list= listOf("a","b","c")
    if(-1 !in 0..list.lastIndex){
        println("-1 is out of range")
    }
    if(list.size !in list.indices){
        println("list size is out of valid list indices range too")
    }
    //区间迭代
    for (x in 1..5){
        println(x)
    }
    //数列迭代,间隔2
    for(x in 1..10 step 2){
        print(x)
    }
    println()
    //downto 反序
    for(x in 9 downTo 0 step 3){
        print(x)
    }
    println()
    //使用in判断是否包含某实例
    when{
        "apple" in items -> println("juicy")
    }
    //使用lambda 表达式来过滤(filter)和映射(map)
    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{ println(it)}
    //只读map
    val map= mapOf(
            "b" to 2,
            "c" to 3,
            "a" to 1
    )
    //访问map
    println(map["b"])
//    //延迟属性
//    val p:String by lazy {
//        (it)
//    }
    //扩展函数
    println("Convert this to camelcase".spaceToCamelCase())
    //if not null 编写
    val files=File("Test").listFiles()
    println(files?.size)
    //if not null else
    var files1=File("Test").listFiles()
    println(files1?.size?:"Empty")
//    //if null 执行一个语句
//    val data=null
//    val email=data["email"]?:throw IllegalStateException("Email is missing")
    // if not null 语句
    val data="dasdsa"
    data?.let{
        println("如果null不为空")//如果data不为空则会执行到这
    }
    println("颜色参数:"+transform("Red"))
//    println("颜色参数:"+transform("R"))
    println("Unit Builder:"+arrayOfMinsOnes(2))

    //数字装箱不必保留同一性
    val a3:Int=10000
    println(a3===a3)
    val boxedA:Int?=a
    val anotherBoxdA:Int?=a
    println(boxedA===anotherBoxdA)

    //显式转换来拓宽数字
    val b2:Byte=1
    val i:Int=b2.toInt()
    println(i)

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

    //控制流
    //when取代switch操作
    when(x){
        1-> print("X==1")
        2-> print("X==2")
        in 1..10-> println("in the range")
        else->{
            println("neither 1 or 2")
        }
    }
    val x3="asd"
    val hasPrefix=when(x3){
        is String->x3.startsWith("a")
        else->false
    }
    println(hasPrefix)

    //循环
    val s3= listOf(1,2,4)
    for(i in s3.indices){
        println(s3[i])
    }
    foo();
    foo1();
    //创建类的实例
//    val customer =Customer("dasda","adasd")
//    var counter=0
//    set(value){
//        if(value>=0)
//            field=value
//    }
}
//定义函数
//返回类型为Unit的方法Builder风格用法
fun arrayOfMinsOnes(size:Int):IntArray{
    return IntArray(size).apply { fill(-1) }
}
//try catch表达式
fun test(){
    val result=try{
        foo()
    }catch (e:ArithmeticException){
        throw IllegalArgumentException(e)
    }
    println(result)
}

//返回when表达式
fun transform(color:String):Int{
    return when(color){
        "Red"->0
        "Green"->1
        "Blue"->2
        else->throw IllegalArgumentException("Invalid color param value")
    }
}

//带两int参数，返回int函数
fun sum(a:Int,b:Int):Int{
    return a+b;
}

//将表达式作为函数体，返回值类型为自动推断的函数
fun sum1(a:Int,b:Int)=a+b;

//函数返回无意义的值
fun printSum(a:Int,b:Int):Unit{
    println("sum of $a and $b is ${a+b}")
}

fun maxOf(a:Int,b:Int)=if(a>b)a else b
//使用可空及null检测
//当某个变量的值可以为null的时候，必须在声明处的类型后添加？来标识该引用为空
//如果str的内容不是数字返回null

fun parseInt(str:String): Int? {
    return null
}

//使用返回可空值函数
fun printProdoct(arg1:String,arg2:String){
    val x=parseInt(arg1)
    val y=parseInt(arg2)
    if (x!=null&&y!=null){
        println(x*y)
    }
    else{
        println("either '$x'or '$y' is not a number")
    }
}
//使用类型检测以及自动类型转换
//is运算符
fun getStringLength(obj:Any):Int?{
    if (obj is String){
        //'obj'在该条件分支自动转换成'String'
        return obj.length
    }
    //离开类型分支检测后仍然是any类型
    return null
}

fun describle(obj :Any):String=
    when(obj){
        1          ->"One"
        "Hello"   ->"Greeting"
        is Long   ->"Long"
        !is Long  ->"Not a String"
        else      ->"Unknown"
    }

//创建DTOs
data class Customer(val name:String,val email:String)
//为customer类提供(set and get,equals,toString,hashCode,copy)

//函数的默认参数
fun foo(a:Int=0,b:String=""){}

//过滤list
val list= listOf(1,2,3)
val positives=list.filter { x->x>0 }
val positive=list.filter { it>0 }//简化
//扩展函数

fun String.spaceToCamelCase(){
    println("das")
}
//创建单例

object Resource{
    val name="Name"
}

//class Array<T> private constructor(){
//    val size :Int
//    operator fun get(index:Int):T
//    operator fun set(index:Int,value: T):Unit
//    operator fun iterator():Iterator<T>
//}

//返回和跳转
//标签处返回
fun foo(){
    val ints= listOf(1,2,0,3)
    ints.forEach {
        if(it==0)return
        println(it)
    }
}
fun foo1() {
    val ints = listOf(1, 2, 0, 3,4,0,5)
    //输出所有非0
    ints.forEach lit@ {
        if (it == 0) return@lit
        println(it)
    }
}
fun foo2() {
    val ints = listOf(1, 2, 0, 3,4,0,5)
    //输出所有非0
    ints.forEach  {
        if (it == 0) return@forEach
        println(it)
    }
}

//类和对象
//在kotlin中都有一个默认的超类Any

//可以有一个主构造函数和一个或多个次构造  函数
class Person constructor(firstname:String){}
//如果构造函数没有任何注解或者可见性修饰符，constructor
class Person1 (firstname: String){}
//主构造函数不能包含任何代码，初始化代码可以放到以init为关键字里面
class Customer1(name: String){
    //可以在类体声明的初始化器中使用
    val customerkey=name.toUpperCase()
    init {
        println("${name}")
    }
}
//更简洁的初始化属性
class Customer2 (val name: String){

}

//次构造函数
class Persion3(val name: String){
    //次构造函数必须要有 constructor
    constructor(name: String,parent:Persion3) : this(name) {//this关键字委托到同一个类的另外一个关键字
//        parent.children.add()
//        parent.children.add(this)
    }
}
class Example//从Any隐式继承
//声明一个显式的超类型
open class Base{
    open fun v(){}
    fun nv(){}
}
class Derviced(p:Int): Base() {
    //覆盖方法
    override fun v() {
        super.v()
    }
}
interface Foo{
    val count:Int
}
class Bar1(override val count:Int):Foo
class Bar2:Foo{
    override var count: Int=0//可以用var覆盖val
}
open class A{
    open fun f(){ print("A")}
    fun a(){ print("A")}
}
interface B {
    fun f(){ print("B")}
    fun b(){
        println("b")}
}
class C():A(),B{
    //编译器要求覆盖f()
    override fun f() {
        super<A>.f()//
        super<B>.f()
    }
}
class Address{
    var name:String="a"
    var street:String="b"
}
fun copyAddress(address: Address):Address{
    val result=Address()//没有new
    result.name=address.name//调用访问器
    result.street=address.street
    return result
}
val size:Int = 0
//自定义getter
//val isEmpty:Boolean
//get() = this.size==0
//自定义setter
//var stringRepresentation:String
//    get()=this.toString()
//    set(value){
//
//    }

