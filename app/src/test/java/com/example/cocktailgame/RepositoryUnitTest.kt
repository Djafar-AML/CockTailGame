package com.example.cocktailgame

import android.content.SharedPreferences
import com.example.cocktailgame.common.network.CocktailsApi
import com.example.cocktailgame.common.repo.Repo
import com.example.cocktailgame.common.repo.RepoImpl
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*

class RepositoryUnitTest {

    private lateinit var repo: Repo
    private lateinit var api: CocktailsApi
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var sharedPrefsEditor: SharedPreferences.Editor

    @Before
    fun setup() {

        api = mock()
        sharedPrefs = mock()
        sharedPrefsEditor = mock()
        whenever(sharedPrefs.edit()).thenReturn(sharedPrefsEditor)

        repo = RepoImpl(api, sharedPrefs)
    }

    @Test
    fun saveScore_shouldShouldSaveToSharedPrefs() {

        val score = 100
        repo.saveHighScore(score)

//      Use inOrder to check that the subsequent verifications are executed in the exact order
        inOrder (sharedPrefsEditor) {

            verify(sharedPrefsEditor).putInt(any(), eq(score))
            verify(sharedPrefsEditor).apply()
        }
    }

    @Test
    fun getScore_shouldGetFromSharedPrefs() {

        repo.getHighScore()

        verify(sharedPrefs).getInt(any(), any())
    }
}