package com.example.cocktailgame.model


class Game(highest: Int = 0) {

    private var questions = listOf<Question>()

    constructor(questions: List<Question>) : this() {
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

        if (questionIndex + 1 < questions.size){
            questionIndex = questionIndex.inc()
            return questions[questionIndex]
        }

        return null
    }

    fun answer(question: Question, option: String) {
        question.answer(option)
    }
}