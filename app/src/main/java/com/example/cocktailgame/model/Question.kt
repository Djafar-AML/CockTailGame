package com.example.cocktailgame.model

class Question(val correctOption: String,
               val incorrectOption: String) {

    var answeredOption: String? = null
        private set

    val isAnsweredCorrectly: Boolean
        get() = correctOption == answeredOption

    @Throws(IllegalArgumentException::class)
    fun answer(option: String): Boolean {

        if (option != correctOption && option!= incorrectOption)
            throw IllegalArgumentException("Not a valid option")

        answeredOption = option
        return isAnsweredCorrectly
    }

    fun shuffleOptions(): List<String> {

        val options = listOf(correctOption, incorrectOption)

        return options.shuffled()
    }
}