package com.example.game

import org.junit.Assert
import org.junit.Test

class QuestionUnitTests {

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnswerOption() {

        val question = Question("Correct", "Incorrect")

        Assert.assertNull(question.answeredOtion)

    }


}