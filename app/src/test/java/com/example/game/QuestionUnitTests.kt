package com.example.game

import com.example.game.model.Question
import org.junit.Assert
import org.junit.Test

class QuestionUnitTests {

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnswerOption() {

        val question = Question("Correct", "Incorrect")

        Assert.assertNull(question.answeredOption)

    }


}