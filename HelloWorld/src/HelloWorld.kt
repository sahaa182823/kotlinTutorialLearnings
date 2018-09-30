import java.util.*

fun main(args: Array<String>) {
    var salary: Int = 30000
    val language : String = "English"

    val id = arrayOf(1,2,3,4)
    val firstid = id[0]
    val lastid = id[id.size-1]

    val asc = Array(5,{i -> i*2})
//    val first = asc[0]
    val second = asc[1]
//    val third = asc[2]
    val fourth = asc[3]
//    val fifth = asc[asc.size-1]

    val test = """
        Welcome
          To
        Kotlin
    """.trimIndent()

    var value : Double = 126.856
    var value2 : Byte = value.toByte()

    val a = 5
    val b = 6

    val max = if (a>b){
        println("a greater than b")
        a
    }
    else{
        println("b greater than a")
        b
    }

    println("max = $max")
//using readLine hare we are taking inputs
//    println("Enter your name :\n")
//    val name  = readLine().toString()
//    println("Enter your Age:\n")
//    val age : Int = Integer.valueOf(readLine())
//    println("your name is $name and your age is $age" )
////using Scanner class hare we are taking inputs
//    val read = Scanner(System.`in`)
//    println("Enter your age")
//    var age1 = read.nextInt()
//    println("your input age is " + age1)


    val num1 = 100
    val num2 = 200
    val num3 = 300
    val result = if (num1 > num2){

        val maxi = if(num1 > num3){
            num1
        }else{
            num3
        }
        "body of if "+ maxi
    }

    else if(num2 > num3){
        "body of else if"+num2
    }

    else{
        "body of else "+num3
    }

    println("$result")
//------------------------------------------------------------------------------------------------
// use of when expression
    val number = 4
    when(number){
        1 -> println("first")
        2 -> println("second")
        3 -> println("third")
        4 -> println("fourth")
        else -> println("Invalid")
    }

    val guess = 5
    when(guess){
        in 1..5 -> println("hi there u r normal")
        in 6..10 -> println("woow...u r abnormal")
    }
//--------------------------------------------------------------------------------------------------
    val item = Array(5, {i-> i*2})

    for(m in item)
        println(m)

    val teams = arrayOf(1,2,3,4,88)
    for(team in teams.indices)
        println("team no $team"+teams[team])

//    val list = arrayOf(1,2,3,4,5,6,7,8,9)

    for(i in 1..9 step 2)
        println(i)

    for(i in 9 downTo 1 step 3)
        println(i)

    var whi = 5
    var i=0

    while( i <5)
    {
        println(whi)
        i++
    }
    println()
    for(i in 1..5){
        if(i==3)
            break
        else
            println(i)
    }


    println()
   loop@ for(i in 1..3){
        for(j in 1..3){
            println("i = $i and j = $j")
            if(i == 2)
                break@loop
        }
    }

    println(value % fourth)
    println(value2)
    println(test)
    println( second )
    println(lastid)
    println(firstid)
    println("Hello World"+" " + salary +" "+ language)

    val number = 4
    val result: Long
    result = factorial(number)
    println("Factorial of $number = $result")
}

tailrec fun factorial(n: Int, run: Int = 1): Long {

    return if (n == 1) {
        run.toLong()
    } else {
        factorial(n - 1, run * n)

    }
}