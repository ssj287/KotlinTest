fun main(args: Array<String>) {
    val items= listOf("apple","banana","kiwi")
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
}