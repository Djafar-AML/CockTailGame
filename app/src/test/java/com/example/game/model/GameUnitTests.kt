package com.example.game.model

import com.example.cocktailgame.model.Game
import com.example.cocktailgame.model.Question
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.*


class GameUnitTests {

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {

        val game = Game()

        game.incrementScore()

        Assert.assertEquals("Current score should have been 1", 1, game.currentScore)

    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {

        val game = Game()

        game.incrementScore()

        Assert.assertEquals("Current high score should have been 1", 1, game.highestScore)

    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {

        val game = Game(10)

        game.incrementScore()

        Assert.assertEquals(10, game.highestScore)

    }

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

        val game = Game(listOf(question))

        game.answer(question, "Option")

        Assert.assertEquals(1, game.currentScore)

    }

    @Test
    fun whenAnsweringIncorrectly_shouldNotIncrementCurrentScore() {

        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(false)

        val game = Game(listOf(question))
        game.answer(question, "Option")

        Assert.assertEquals(0, game.currentScore)

    }
}