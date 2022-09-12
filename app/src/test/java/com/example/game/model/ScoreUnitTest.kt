package com.example.game.model

import com.example.cocktailgame.model.Score
import org.junit.Assert
import org.junit.Test

class ScoreUnitTest {

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {

        val score = Score()

        score.increment()

        Assert.assertEquals("Current score should have been 1", 1, score.current)

    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {

        val score = Score()

        score.increment()

        Assert.assertEquals("Current high score should have been 1", 1, score.highest)

    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {

        val score = Score(10)

        score.increment()

        Assert.assertEquals(10, score.highest)

    }
}