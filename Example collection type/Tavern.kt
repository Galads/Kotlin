import kotlin.math.roundToInt
import java.io.File

val menuList = File("Data/tavern-menu-items.txt")
    .readText()
    .split("\r")

//val patronGold = mutableMapOf("Elie" to 10.5, "John" to 8.0, "Galads" to 5.5)//pair type
val patronGold = mutableMapOf<String, Double>()
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")

val uniquePatrons = mutableSetOf<String>()

const val TAVERN_NAME = "Taernyl's Folly";


val patronList = mutableListOf("Elie", "John", "Galads")


fun main(args: Array<String>) {

    if(patronList.containsAll(listOf("John", "Galads"))){
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else{
        println("The tavern master says: Nay, they departed hours ago.")
    }
    //for (patron in patronList){
      //  println("Good evening $patron")
    //}
   // patronList.forEach{patron ->
     //   println("Good evening $patron")
    //}
    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"

        uniquePatrons += name
    }
    println("$uniquePatrons")

    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }
   // println(patronGold)
    var orderCount = 0
    while(orderCount <= 9){
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
    displayPatronBalances()
}

private fun displayPatronBalances() {
    patronGold.forEach{ patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun placeOrder(patronName: String, menuOrder: String){

    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("$patronName говорит с $tavernMaster по поводу заказа")

    val (type, name, price) = menuOrder.split(',') //возвращает список подстрок в порядке их следования (подстроки с индексированным доступом)
    val message = "$patronName bye a $name ($price) for $price"

    println(message)
    performPurchase(price.toDouble(), patronName)
    val phrase = if(name == "Dragon's Breath"){
        "$patronName exclaims ${toDragonSpeak("Ah, Delicious $name")}"
    } else{
        "$patronName says: Thanks for the $name"
    }

    println(phrase)
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase:String) =
    phrase.replace(Regex("[aeiou]")){
        when(it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }



