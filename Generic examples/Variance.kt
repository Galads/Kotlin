package com.bignerdranch.hucker

class Barriel<in T>(item:T)

fun main(){
    var fedoraBarriel: Barriel<Fedora> = Barriel(Fedora("универсальна фетровая шляпа", 15))
    var lootBarriel: Barriel<Loot> = Barriel(Coin(15))

     fedoraBarriel = lootBarriel


}