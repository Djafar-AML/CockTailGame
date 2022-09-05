package com.example.cocktailgame.model

import com.example.game.model.Question

class Game(highest: Int = 0) {

    private var questions = listOf<Question>()

    constructor(questions: List<Question>) : this(){
        this.questions = questions
    }

    var currentScore = 0
        private set
    var highestScore = highest
        private set

    private var questionIndex = -1

    fun incrementScore() {

        currentScore = currentScore.inc()

        if (currentScore > highestScore)
            highestScore = currentScore
    }

    fun nextQuestion(): Question? {
        return null
    }
}