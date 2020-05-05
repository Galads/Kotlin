fun main(args: Array<String>) {
    var swordJuggler: Int? = null
    var isJugglingProficent = (1..3).shuffled().last() == 3
    if (isJugglingProficent){
        swordJuggler = 2
    }
    try {
        proficiencyCheck(swordJuggler)
        swordJuggler = swordJuggler!!.plus(1)
    } catch (e: Exception){
        println(e)
    }

    println("You juggle $swordJuggler swords!")
}
fun proficiencyCheck(swordJuggler: Int?){
    require(swordJuggler!! >= 3 , {"Juggle at least 3 swords to be exciting."})
}
class UnskilledSwordJugglerException():
    IllegalStateException("Player cannot juggle swords")
