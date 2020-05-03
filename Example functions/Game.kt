fun main(args: Array<String>) {
    val name = "Galads"
    val isBlassed = true //blagoslovenie
    val isImmortal = false // bessmertie
    var healthPoints = 89

    val auraColor = auraColor(isBlassed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlassed)

    printPlayerStatus(auraColor, isBlassed, name, healthStatus)
    castFireball()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlassed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Аура: $auraColor) " + "(Благословение: ${if (isBlassed) "ДА" else "НЕТ"})")
    println("$name$healthStatus")
}

private fun auraColor(isBlassed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlassed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlassed: Boolean): String  =
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

private fun castFireball(numFireballs: Int = 2) =
    println("Бокал с огненным шаром появляется на свет. (x$numFireballs)")
