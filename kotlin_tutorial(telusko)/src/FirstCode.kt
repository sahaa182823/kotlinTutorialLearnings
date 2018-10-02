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

    //implementing Constructor in Inheritance
    var plant : Tree = CoconutTree(20) // hare "age" is passing to CoconutTree primary constructor
    // first then it is getting passed to Tress primary constructor


    //Implementing the Concept of Abstract Class
    var bhumika : Girl = Woman()
    bhumika.talk()
    bhumika.think()

    //Implementing Interface
    var obj8 =  C()

    obj8.show()
    obj8.display()
    obj8.ABC()

    //Implementing Data class
    var lap1 = Laptop("Dell",2000)
    var lap2 = Laptop("Apple",2500)
    var lap3 = lap1.copy(prize = 2200) // if you want to change value of any parameter you have to define like this

    println(lap3)

    println(lap1.equals(lap2))

    // what data class is actually doing is by implementing "Data" infront of a class you can enable this features:
    //  1) enabling toString()
    //  2) .equals() and hashCode
    //  3) .copy()


    // Implementing Object keyword

    Bookshelf.books.add(Book("java",50))
    Bookshelf.books.add(Book("c",40))
    Bookshelf.books.add(Book("Sql",80))

    Bookshelf.showbooks()


    // implementing Anonymous inner class
    var programar = object : Humaninterface // here object keyword is used to initialize anonymous class object of Humaninterface
    {
        override fun think() {
            println("think virtually...")
        }
    }

    programar.think()

    //implementing Companion object
    AB.show()


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
        println("kotlin is awsome .. $name")
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

// Implementing Inheritance
open class Newhuman()
{
    open fun think() // "open" also allows you to override a final method bcz in kotlin method and class are by default final
    {
        println("Real Think")
    }
}

class AlienMan : Newhuman(){
    override fun think() // override will allow you to override a method otherwise you cant't
    {
        println("virtual Thinking")
    }
}


//constructor in inheritance
open class Tree(age : Int)// it means primary constructor
{
    init {
        println("In Tree and age is $age")
    }
    open fun root(){
        println("Tree sucks water")
    }
}

class CoconutTree(age : Int) : Tree(age){
    init {
        println("In CoconutTree")
    }
    override  fun root(){
        println("Coconut tree sucks water")
    }
}

//Concept of Abstract Class
abstract class Girl{
    abstract fun think()

    fun talk(){
        println("Talking....")
    }
}

class Lady : Girl(){
    override fun think() // according to abstruct class you have to implement this think() abstract method other wise it will also be a abstract class
    {
        println("Thinking about marriage")
    }
}

class Woman : Girl(){
    override fun think()
    {
        println("Thinking about child")
    }
}


// Implementing Interface
interface A{
    fun show()
    fun ABC(){
        println("in ABC A")
    }
}

interface B{
    fun display()
    fun ABC(){
        println("in ABC B")
    }
}

class C : A,B{

    override fun show(){
        println("in show")
    }
    override  fun display(){
        println("in display")
    }
    override fun ABC(){
        println("in ABC C")
        // but if you want to call ABC() of a particular interface then you have to use "super<name of interface>" generics to solve the issue
        super<A>.ABC()
    }
}

//Implementing Data Class
data class Laptop(val brand: String,val prize : Int){
    fun show (){
        println("My laptop is awsome....")
    }
}

//Using object keyword
data class Book (var name :  String , var prize :  Int )

object Bookshelf // this will be treated as a object itself so dont need to create object in main()
{
     var books = arrayListOf<Book>()

        fun showbooks(){
            for(i in books){
                println(i)
            }
        }
}

//Anonymous Inner class

interface Humaninterface{
    fun think();
}

//Companion object
class AB{
    companion object {
        @JvmStatic // if want to use any method as static we need to deaclear annotation @JvmStatic and we have to use "companion object"
        fun show(){
            println("hello")
        }
    }
}




