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

    @Test
    fun whenAnswering_shouldHaveAnsweredOption() {

        val question = Question("Correct", "Incorrect")

        question.answer("Incorrect")

        Assert.assertEquals("Incorrect", question.answeredOption)

    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue() {

        val question = Question("Correct", "Incorrect")

        val result = question.answer("Correct")

        Assert.assertTrue(result)

    }

}