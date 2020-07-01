fun main(args: Array<String>) {
    val player = Player()

    printPlayerStatus(player)

    player.castFireball()
}

private fun printPlayerStatus(player: Player){
    println("(Аура: ${player.auraColor()}) " +
            "(Благословение: ${if (player.isBlassed) "ДА" else "НЕТ"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

