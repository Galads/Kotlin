@file:JvmName("Hero")

import java.io.IOException
import java.lang.Exception

@Throws(IOException::class)
fun acceptApology(){
    throw IOException()
}

class SpellBooks{
    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")

    companion object{
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellBooksGreeting() = println("I am the Great Grimoire!")
    }
}

fun main(){
    val opponent = Jhava()

    println(opponent.utterGreeting())

    val friendShipLevel = opponent.determineFriendShip()

    println(friendShipLevel?.toLowerCase() ?: "it's null")

    val opponentHitPoints: Int = opponent.hitPoints

    println(opponentHitPoints.dec())//  -1
    println(opponentHitPoints.javaClass)

    opponent.greeting = "Helo, Hero!"

    println(opponent.utterGreeting())

    opponent.offerFood()

    try {
        opponent.extendHandInFriendship()
    }catch(e: Exception){
        println("Begone, foul beast!")
    }
}

val translator = { speech: String ->
    println(speech.toLowerCase().capitalize())
}

fun makeProclamation() = "greetings, best!"

@JvmOverloads
fun handOverFood(leftHand:String = "berries", rightHand:String = "beef"){
    println("Mmmm... you hand over some Delicious $leftHand and $rightHand.")
}