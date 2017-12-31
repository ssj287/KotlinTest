fun main(args: Array<String>) {
//使用区间
//in检测是否在区间内
    val x1 = 10
    val y1 = 9
    if (x1 in 1..y1) {
        println("在这个区间")
    } else {
        println("不在这个区间")
    }
//检测某个数字是否在某个区间外
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}