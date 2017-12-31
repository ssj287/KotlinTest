fun main(args: Array<String>) {
    var x=5
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
}
