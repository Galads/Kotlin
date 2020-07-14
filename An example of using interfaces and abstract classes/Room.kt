package com.bignerdranch.hucker

open class Room(val name: String) {
    var monster: Monster? = Goblin()

    protected open val dangereLevel = 5

    fun description() = "Комната: $name" +"\n"+
            "Уровень опасности: $dangereLevel" +"\n"+
            "Существa: ${monster?.description ?: " нет."}"

    open fun load() = "Здесь нечего смотреть..."
}

open class townSquare : Room ("Городская площадь"){
    final override fun load() = "Жители деревни объединяются и приветствуют вас при входе! \n" +
            "${ringBell()}"
    override val dangereLevel = super.dangereLevel - 3

    private val bellSound = "ДЗЫНЬ"
    open fun ringBell() = "Колокольня объявляет о вашем прибытии. $bellSound"
}
