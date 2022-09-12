package com.example.game.model

import com.example.cocktailgame.model.Game
import com.example.cocktailgame.model.Question
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


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
}