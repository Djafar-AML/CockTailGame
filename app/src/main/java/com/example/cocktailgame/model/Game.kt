package com.example.cocktailgame.model


class Game(private val questions: List<Question>, val score: Score = Score(0)) {


    private var questionIndex = -1


    fun nextQuestion(): Question? {

        if (questionIndex + 1 < questions.size){
            questionIndex = questionIndex.inc()
            return questions[questionIndex]
        }

        return null
    }

    fun answer(question: Question, option: String) {

        val result = question.answer(option)

        if (result)
            score.increment()
    }
}