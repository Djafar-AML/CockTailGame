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
}