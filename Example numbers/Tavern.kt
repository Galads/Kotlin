import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly";
var playerGold = 0
var playerSilver = 0
var dracoin = 5
var dracoinInGold = dracoin * 1.43

fun main(args: Array<String>) {

    placeOrder("Шэнди,Dragon breath,5.91 ")
//    placeOrder("Элексир,Shirley's Temple,4.12 ")

}
private fun placeOrder(menuOrder: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    val allPints  = 5

    println("Galads говорит с $tavernMaster по поводу заказа")

    val (type, name, price) = menuOrder.split(',') //возвращает список подстрок в порядке их следования (подстроки с индексированным доступом)
    val priceCheck = price.toDouble()
    val checkFunc = checkBalance(priceCheck)
    if (checkFunc == false){
        val message = "Galads купил $name ($type) за $price"

        println(message)

        performPurchase(price.toDouble(), allPints.toDouble())

        val phrase = if(name == "Dragon breath"){
            "Galads восклицает: ${toDragonPhrase("Ah, delicious $name")}"
        } else{
            "Galads отвечает: спасибо за $name"
        }
        println(phrase)
    }

}
private fun toDragonPhrase(phrase: String) =
    phrase.replace(Regex("[aeoiu]")){
        when(it.value){
            "a" -> "4"
            "e" -> "3"
            "o" -> "0"
            "i" -> "1"
            "u" -> "|_|"
            else -> it.value
        }
    }
private fun performPurchase(price: Double, allPints: Double){
    displayBalance()
    val dracoinCoin = dracoin / 1.43
    val totalPurse = dracoinCoin + playerGold + (playerSilver/100.0)

    println("Кошелек: $totalPurse Золота")

    val remainingBalance = totalPurse - price
    val onePints = 0.125
    val totalGalons = allPints - (onePints*12)
    val totalPints = (totalGalons/0.125).toInt()

    println("Покупка товара по цене $price")
    println("Всего пинт в таверне осталось: $totalPints")
    println ("Оставшиеся галлоны в таверне: $totalGalons")
    println("Оставшийся баланс: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1*100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    dracoin = (playerGold * 1.43).toInt()
    displayBalance()
}
private fun displayBalance() {
    println("У игрока на балансе: Золото: $playerGold , Серебро: $playerSilver Дракоины: $dracoin")
}
private fun checkBalance(priceCheck: Double):Boolean{
    if(dracoinInGold < priceCheck  || playerSilver <((playerGold + (playerSilver/100.0))% 1*100).roundToInt() ) {
        println("Невозможно совершить покупку, Баланс: З: $playerGold С: $playerSilver Д: $dracoin")
        var impossible = true
        return impossible
    } else {
        var impossible = false
        return impossible
    }

}
