package com.example.game.model

class Game {

    var currentScore = 0
        private set

    fun incrementScore() {
        currentScore = currentScore.inc()
    }

}