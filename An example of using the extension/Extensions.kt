package com.bignerdranch.hucker

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

infix fun String?.printWithDefault(default: String) = print(this ?: default)

fun <T> T.easyPrint(): T{
    println(this)
    return this
}

val String.numVowels
    get() = count{"aeouiy".contains(it)}

fun main(){

    "Galads покинул здание".easyPrint().addEnthusiasm().easyPrint()

    42.easyPrint()

    "How many Vowels?".numVowels.easyPrint()

    val nullableString: String?  = null

    nullableString printWithDefault "Default string"

}