package com.example.cocktailgame

import android.content.SharedPreferences
import com.example.cocktailgame.common.network.CocktailsApi
import com.example.cocktailgame.common.repo.RepoImpl
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.*

class RepositoryUnitTest {

    @Test
    fun saveScore_shouldShouldSaveToSharedPrefs() {

        val api: CocktailsApi = mock()

        val sharedPrefsEditor: SharedPreferences.Editor = mock()

        val sharedPrefs: SharedPreferences = mock()

        whenever(sharedPrefs.edit()).thenReturn(sharedPrefsEditor)

        val repo = RepoImpl(api, sharedPrefs)

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

        val api: CocktailsApi = mock()
        val sharedPrefs: SharedPreferences = mock()

        val repo = RepoImpl(api, sharedPrefs)

        repo.getHighScore()

        verify(sharedPrefs).getInt(any(), any())
    }
}