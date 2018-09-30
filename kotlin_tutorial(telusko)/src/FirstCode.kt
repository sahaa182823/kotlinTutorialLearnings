@file:JvmName("First")// If you want to change the class name you have to use this annotation
import java.math.BigInteger
import java.util.*

fun main(args : Array<String>)
{
    var telusko =  Alien();

    telusko.name = "Anirban"

    println("Alien name is ${telusko.name}")


    //String comparison

    var str1 = "Anirban"
    var str2 = "Anirban"

    if(str1 == str2)
        println("same")
    else
        println("not same")

    //handling Null

//    var str : String? = null
    var raja : Alien? = Alien()  // now you can use this as a null object
    raja = null
    println(raja?.name)//if u want to access any property of a null object u have to assign ? before .

    //when Expression

    val number : Int = 2
    val str5 : String = when(number){
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        else -> "please insert valied number"
    }
    println("string is $str5")

    //In looping UNTIL expression and how it works?

    var nums = 1 until 16
    println("total count is ${nums.count()}")
    for(a in nums)
        println(a)

    println("what reversed() actually do is")
    for(i in nums.reversed())
        println(i)

    //use of list and map

    var list = listOf<Int>(1,2,3,4)

    for((i,e) in list.withIndex())
        println("$i : $e")

    var map = TreeMap<String,Int>()
    map["Anirban"] = 23
    map["Ashish"] = 22

    for((name,age) in map)
        println("$name : $age")

    // function iterpretation in a different way
    var result = add(8,7)
    println(result)

    //Default and named parameter
    var finalAmount = calAmount(amt = 50,interest = 0.03) //use of named parameters
    println(finalAmount)

    //try expression
    var str7 : String = "4a"

    var num7 :Int = try{
        str7.toInt()
    }
    catch (e : Exception){
        -1
    }

    num7++
    println(num7)

    //Extension Function

    var a1 =  Alien()
    a1.skills = "Java"
    a1.show()

    var a2 =  Alien()
    a2.skills = "SQL"
    a2.show()

    var a3 = a1 plus a2
    a3.show()

    // operator overloading

    var a4 = a1 + a2
    a4.show()

    //another way to calculate factorial of big number like 70
    var num = BigInteger("70")
    println(fact(num))

    //implementing Tail recursion to avoid stack overflow

    var number1 = BigInteger("700")
    println(factTail(number1,BigInteger.ONE))

    // use of Primary constructor

    var obj = Human("Anirban")
    obj.think()

    //use of secondary constructor

    var obj2 = Human2(20,"Anirban")
    obj2.think2()

    //Implementing Inheritence
    var Raja : Newhuman = AlienMan()
    Raja.think()

}

fun add(a : Int, b: Int) : Int = a + b

@JvmOverloads // if you want to call this method from java class and you you want to send 1 parameter only you have to use this annotation
fun calAmount(amt : Int, interest : Double = 0.04):Int{
    return (amt + amt*interest).toInt()
}

//use of Extension Function
//use of infix function
// use of operator overloading
operator infix fun Alien.plus(a : Alien) :  Alien {
    var newAlien = Alien()
    newAlien.skills = this.skills + " " + a.skills
    return newAlien
}


//recursion function using biginteger

fun fact(num : BigInteger) : BigInteger {
    if (num == BigInteger.ZERO)
        return BigInteger.ONE
    else
        return num * fact(num- BigInteger.ONE)
}

//implementing Tail recursion

tailrec fun factTail(number1: BigInteger, result1 : BigInteger) : BigInteger{
    if(number1 == BigInteger.ZERO )
        return result1
    else {
        return factTail(number1 - BigInteger.ONE, number1 * result1)
    }
}

//implementing primary constructor in kotlin
//Primary constructor

class Human(var n : String){
    var name : String = n
    fun think(){
        println("kortlin is awsom .. $name")
    }
}

// Implementing Secondary Constructor in kotlin
// secondary constructor

class Human2(var n : String){

    var name : String = n
    var age : Int = 0

    constructor(Age: Int,name:String): this(name){
            this.age = Age
    }

    fun think2(){
        println("kotlin is awsome .. $name and age is $age")
    }
}

// Implementing Inheritence
open class Newhuman(){
    open fun think(){
        println("Real Think")
    }
}

class AlienMan : Newhuman(){
    override fun think() {
        println("virtual Thinking")
    }
}

