fun main(args: Array<String>) {
    val items= listOf("apple","banana","kiwi")
    when{
        "apple" in items -> println("juicy")
    }
    //使用lambda 表达式来过滤(filter)和映射(map)
    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{ println(it)}
}