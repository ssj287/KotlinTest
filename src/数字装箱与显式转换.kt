fun main(args: Array<String>) {
    val a:Int=1//立即赋值
//数字装箱不必保留同一性
    val a3: Int = 10000
    println(a3 === a3)
    val boxedA: Int? = a
    val anotherBoxdA: Int? = a
    println(boxedA === anotherBoxdA)

//显式转换来拓宽数字
    val b2: Byte = 1
    val i: Int = b2.toInt()
    println(i)
}