package com.bignerdranch.hucker.extentions

fun <T> Iterable<T>.random(): T = this.shuffled().first()