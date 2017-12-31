fun main(args: Array<String>) {//区间迭代
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
}