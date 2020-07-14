package com.bignerdranch.hucker

import java.lang.Exception
import java.lang.IllegalStateException 
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    Game.play()

}

object Game {
    private var player = Player("galads", true, false)
    private var currentRoom: Room = townSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Таверна"), Room("Задняя комната")),
        listOf( Room("Длинный коридор"), Room("Общая комната"))
    )

     fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)

            if (!newPosition.isInBounds){
                throw IllegalStateException("$direction выходит за пределы")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]

            player.currentPosition = newPosition
            currentRoom = newRoom

            "Хорошо, вы двигаетесь на: $direction к локации ${newRoom.name}.\n ${newRoom.load()}"
        }catch (e: Exception){
            "Неверное направление: $directionInput."
        }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0){
            slay(it)
            Thread.sleep(1000)
        }
        "Бой завершен."
    }?: "Здесь не с кем драться."

    private fun slay(monster: Monster){
        println("${monster.name} нанес ${monster.attack(player)}")
        println("${player.name} нанес ${player.attack(monster)}")
        if (player.healthPoints <= 0) {
            println(">>>> Вы были побеждены. Спасибо за иру. <<<<")
            exitProcess(0)
        }
        if (monster.healthPoints <= 0){
            println(">>>> ${monster.name} был побежден. <<<<")
            currentRoom.monster = null
        }
    }

    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

        fun processCommand() = when (command.toLowerCase()){
            "fight" -> fight()
            "map" -> printPosition()
            "move" -> move(argument)
            else -> commandNotFound()

        }

        private fun commandNotFound() = "Я не совсем понимаю что вы пытаетесь сделать"

        }
         fun printPosition(){
            // var position = player.currentPosition
             //println(position)

             val map:  Array<Array<String>> = Array(2, { Array(3, {"0"}) })
             map[1][2] = ""
             map[player.currentPosition.y][player.currentPosition.x] = "X"

             for(row in map){
                 for(cell in row){
                     print("$cell\t")
                 }
                 println()
             }
        }

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
            //
            var commandWhile = readLine()
            if (commandWhile == "quit") {
                print("Выход из игры")
                break
            }
            //readLine() in println later
            println(GameInput(commandWhile).processCommand())

        }
    }

    private fun printPlayerStatus(player: Player){
        println("(Аура: ${player.auraColor()}) " +
                "(Благословение: ${if (player.isBlassed) "ДА" else "НЕТ"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}