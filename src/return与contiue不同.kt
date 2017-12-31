fun main(args: Array<String>)
{
    foo();
    foo1();
    foo2();
}
//fun foo(){
//    val ints= listOf(1,2,0,3)
//    ints.forEach {
//        if(it==0)return
//        println(it)
//    }
//}
//fun foo1() {
//    val ints = listOf(1, 2, 0, 3,4,0,5)
//    //输出所有非0
//    ints.forEach lit@ {
//        if (it == 0) return@lit
//        println(it)
//    }
//}
//fun foo2() {
//    val ints = listOf(1, 2, 0, 3,4,0,5)
//    //输出所有非0
//    ints.forEach  {
//        if (it == 0) return@forEach
//        println(it)
//    }
//}
