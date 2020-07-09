package com.bignerdranch.hucker

fun main(args: Array<String>) {

    Game.play()
}

object Game {
    private val player = Player("galads", true, false)
    private var currentRoom: Room = townSquare()


    init {
        println("Welcome adventurer")
        player.castFireball()
    }
    fun play(){
        while (true){
            //game process
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Введите комманду: ")
            println("Последняя команда: ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player){
        println("(Аура: ${player.auraColor()}) " +
                "(Благословение: ${if (player.isBlassed) "ДА" else "НЕТ"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}

