package com.bignerdranch.hucker

import java.io.File

class Player(
    _name: String,
    val isBlassed: Boolean,
    private val isImmortal: Boolean,
    var healthPoints: Int = 100
    ){
    //val isBlassed = _isBlassed //blagoslovenie
    //private  val isImmortal = _isImmortal// bessmertie
    //var healthPoints = _healthPoints

    var name = _name
        get() = "${field.capitalize()} из $hometown"
        private set(value){
            field = value.trim()// del space
        }

    val hometown = selectHometown()

    var currentPosition = Coordinate(0,0)


   
    private fun selectHometown() = File("Data/towns.txt")
        .readText()
        .split("\r\n")
        .shuffled()
        .first()

    init {
        require(healthPoints>0,{"Очки здоровья должны быть больше 0."})
        require(name.isNotBlank(), {"У игрока должно быть имя."})
    }
    constructor(name: String) : this(name,
        isBlassed = true,
        isImmortal = false
        ){
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    fun castFireball(numFireballs: Int = 2) =
        println("Бокал с огненным шаром появляется на свет. (x$numFireballs)")

    fun auraColor(): String {
        val auraVisible = isBlassed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }
    fun formatHealthStatus(): String  =
        when (healthPoints) {
            100 -> " В отличном состоянии!"
            in 90..99 -> " Имеет несколько царапин."
            in 75..89 -> if (isBlassed) {
                " Имеет незначительные раны, но они заживают быстро!"
            } else {
                " Имеет незначительные раны."
            }
            in 15..74 -> " Выглядит довольно больно."
            else -> " В ужасном состоянии!"
        }
}