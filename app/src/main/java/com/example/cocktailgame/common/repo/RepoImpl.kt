package com.example.cocktailgame.common.repo

import android.content.SharedPreferences
import com.example.cocktailgame.common.network.CocktailsApi

private const val HIGH_SCORE_KEY = "HIGH_SCORE_KEY"

class RepoImpl(
    private val api: CocktailsApi,
    private val sharedPrefs: SharedPreferences
) : Repo {

    override fun saveHighScore(score: Int) {

        val highScore = getHighScore()
        if (score > highScore) {
            val editor = sharedPrefs.edit()
            editor.putInt(HIGH_SCORE_KEY, score)
            editor.apply()
        }
    }

    override fun getHighScore() = sharedPrefs.getInt(HIGH_SCORE_KEY, 0)

}