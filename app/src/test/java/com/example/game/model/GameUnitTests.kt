package com.example.game.model

import com.example.cocktailgame.model.Game
import com.example.cocktailgame.model.Question
import com.example.cocktailgame.model.Score
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.*


class GameUnitTests {


    @Test
    fun whenGettingNextQuestion_shouldReturnIt() {

        val question = Question("Correct", "Incorrect")
        val questions = listOf(question)
        val game = Game(questions)

        val nextQuestion = game.nextQuestion()

        Assert.assertSame(question, nextQuestion)

    }

    @Test
    fun whenGettingNextQuestion_withoutMoreQuestions_shouldReturnNull() {

        val question = Question("Correct", "Incorrect")
        val questions = listOf(question)
        val game = Game(questions)

        game.nextQuestion()
        val nextQuestion = game.nextQuestion()

        Assert.assertNull(nextQuestion)

    }

    @Test
    fun whenAnswering_shouldDelegateToQuestion() {

        val question = mock<Question>()
        val game = Game(listOf(question))

        game.answer(question, "Option")

        verify(question, times(1)).answer(eq("Option"))

    }

    @Test
    fun whenAnsweringCorrectly_shouldIncrementCurrentScore() {

        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(true)

        val score = mock<Score>()

        val game = Game(listOf(question), score)

        game.answer(question, "Option")

        verify(score, times(1)).increment()

    }

    @Test
    fun whenAnsweringIncorrectly_shouldNotIncrementCurrentScore() {

        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(false)

        val score = mock<Score>()

        val game = Game(listOf(question), score)

        game.answer(question, "Option")

        verify(score, never()).increment()

    }
}