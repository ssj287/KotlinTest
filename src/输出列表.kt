fun main(args: Array<String>) {
    val items = listOf("apple", "banana", "kiwi")
    println("输出列表")
    for (item in items) {
        println("*" + item)
    }
    //指数
    for(index in items.indices){
        println("item at $index is ${items[index]}")
    }
    println("定指向:"+describle("Hello"))
}