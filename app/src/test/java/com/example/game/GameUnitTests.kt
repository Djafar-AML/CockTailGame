package com.example.game

import com.example.game.model.Game
import org.junit.Assert
import org.junit.Test


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
}