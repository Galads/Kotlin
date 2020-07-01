class Player{
    val isBlassed = true //blagoslovenie
    private  val isImmortal = false // bessmertie
    var healthPoints = 89

    var name = "galads"
        get() = field.capitalize()
        private set(value){
            field = value.trim()// del space
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