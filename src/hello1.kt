import kotlin.properties.Delegates

fun main(args: Array<String>) {
    var a:Int=4
    var shl:Int=a shl (1)//左移运算符
    var shr:Int=a shr (1)//右移运算付
    var ushr:Int=a ushr (3)//无符号右移，高位补0
    var and:Int=2 and (4)//按位与操作
    var or:Int=2 or (4)//按位或操作
    var xor:Int=2 xor (6)//按位异或操作
    println(shl)
    println(shr)
    println(ushr)
    println(and)
    println(or)
    println(xor)
    //@定义label，一般用于内层跳出外层循环
    loop@ for (i in 0..2){
        for (j in 0..3){
            println("i:"+i+"j:"+j)
            if(j==2)
                break@loop
        }
    }
    //设置隔步数据大小
    for(i in 1..5 step 3)
    {
        println(i)
    }
    val staff=Staff("codeAndroid","Android工程师","22")//实例化
    staff.name="Qian"
    var staff1=staff.copy()
    var staff2=staff.copy(name = "CCC",position = "kotlin")
    println("name:${staff2.name}  position:${staff2.position}  age:${staff2.age}")
    var anotherstaff=Staff("123Android","Android工程师","11")
    println("1 tostring:${staff.toString()}")
    println("2 tostring:${staff2.toString()}")
    //字符模板
    val name:String="Android"
    println("1 : $name")
    println("2 : ${name}")
    var key=object: KeyBord(){
        override fun OnKeyEvent(code: Unit)=Unit
    }
    display()
    var employee=Employee("CodeAndroid")
    employee.print()
    employee.println()
    println(employee.toString1())
    println(employee.lastname)
    show()
    var water=Water()
    println(water.name)
    println(water.name)
    water.value="1111111111"
    water.value="2222222222"
    water.value="3333333333"
    println(water.value)
    println(water.value)
    water.weight=2
    println(water.weight)
    Singleton.doSomething()
    Myclass.doSomething()
}
open class People private constructor(var id:String,var name:String){
    //可以类初始化属性
    var customName=name.toUpperCase();//初始化属性
    constructor(id:String,name: String,age:Int):this(id,name){
        println("Constructor")
    }
    init {
        println("初始化操作，可用constructor")
    }
    //需要open修饰,子类才可以继承
    open fun study(){
        println("study")
    }
    class Student(id:String,name: String):People(id,name){
        var test:Number=3
        private var name1 : String?
             get() {
                 return name1
             }
             set(value) {
                 name1=value
             }

        override fun study() {
            super.study()
        }
    }
}
//Kotlin数据类
data class Staff<T>(var name: String,val position:String,var age:T){}

//kotlin对象表达式object类似与Java的匿名内部类
open class KeyBord{
    open fun OnKeyEvent(code:Unit)=Unit
}

//枚举
enum class Color{
    Red,Blue,Green
}
fun display(){
    var color:Color=Color.Blue
    Color.valueOf("Blue")//与元素做匹配若没有则报异常
    Color.values()//以数组形式返回枚举值
    println(color.name)
    println(color.ordinal)//输出枚举数组顶定义的顺序
}
//扩展
class Employee(var name:String){
    fun print(){
        println("Employee")
    }
}
//扩展函数
fun Employee.println(){
    print("println:Employee name is ${name}")
}
//可以扩展为一个空函数
fun Any?.toString1():String{
    if (this==null)
        return "toString:null"
    else{
        return "toString:"+toString()
    }
}
/**
 * 扩展属性
 *扩展属性不会像类中添加新成员
 * 无法让属性拥有后缀变量
 * 只能通过明确的setget方法赋值
 * 只能被声明为val
 */
val Employee.lastname:String
    get() {
        return "get:"+name
    }
/**
 * 被代理接口
 */
interface Base1{
    fun display()
}
/**
 * 被代理类
 */
open class BaseImpl:Base1{
    override fun display()= println("just display me")
}
/**
 * 代理类，使用：以及关键词by进行声明
 * 许代理和其他继承属性共用
 */
class Drived(base: Base1):Base1 by base
fun show(){
    var b=BaseImpl()
    var drived=Drived(b)
    drived.display()
}
class Water{
    public var weight:Int by Delegates.notNull()
    /**
     * 代理属性
     */
    public val name:String by lazy {
        println("Lazy..........")
        "Code4Android"
    }
    public var value:String by Delegates.observable("init value"){
        d,old,new->
        println("$d->$old->$new")
    }
}
//单例模式
/**
 * 使用object定义类，该类的实例即为单例，访问单例直接使用类名,不能通过构造函数来访问，
 * Place.doSomething()//访问单例对象
 */
object Singleton{
    fun doSomething(){
        println("doSomething")
    }
}

/**
 * 单例是懒加载，当使用的时候才价值，而对象表达式是初始化的地方加载
 *
 * 以object关键词可以省略类名
 * 访问内部单例对象方法
 */
class Myclass{
    companion object Singleton {
        fun doSomething(){
            println("doSomething")
        }
    }
}