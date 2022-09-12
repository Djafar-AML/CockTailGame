package com.example.cocktailgame.model

class Score(val highestScore: Int = 0) {

    var current = 0
        private set

    var highest = highestScore
        private set

    fun increment() {

        current = current.inc()

        if (current > highest)
            highest = current
    }
}