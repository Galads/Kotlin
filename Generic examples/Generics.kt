package com.bignerdranch.hucker

class LootBox <T : Loot> (vararg item: T){
    var open = false
    private var loot: Array<out T> = item// часть возвр. типа любой перем.

    operator fun get(index:Int): T? = loot[index].takeIf { open }

    fun fetch(item: Int): T?{
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction:(T)->R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

open class Loot(val value: Int)

class Fedora (val name: String, value: Int) : Loot(value)

class Coin (value: Int) : Loot(value)

fun main(){
    val LootBoxOne: LootBox<Fedora> = LootBox(Fedora("универсальную фетровую шляпу", 15),
                                              Fedora("ослепительную пурпурную фетровую шляпу",25)
    )
    val LootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    LootBoxOne.open = true
    LootBoxOne.fetch(1)?.run { println("Вы достаете $name из коробки!")}

    val coin = LootBoxOne.fetch(0){
        Coin(it.value * 3)
    }
    coin?.let{
        println(it.value) }

    val fedora = LootBoxOne[1]
    fedora?.let { 
        println(it.name) }
}

