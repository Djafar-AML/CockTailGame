package com.example.game.factory

import com.example.cocktailgame.common.network.Cocktail
import com.example.cocktailgame.common.repo.Repo
import com.example.cocktailgame.common.repo.RepositoryCallback
import com.example.cocktailgame.model.factory.CocktailGameFactory
import com.example.cocktailgame.model.factory.CocktailGameFactoryImpl
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*

class CocktailGameFactoryUnitTests {

    private lateinit var repository: Repo
    private lateinit var factory: CocktailGameFactory

    @Before
    fun setup() {

        repository = mock()
        factory = CocktailGameFactoryImpl(repository)

    }

    @Test
    fun buildGame_shouldGetCocktailsFromRepo() {
        factory.buildGame(mock())
    }

    private val cocktails = listOf(
        Cocktail("1", "Drink1", "image1"),
        Cocktail("2", "Drink2", "image2"),
        Cocktail("3", "Drink3", "image3"),
        Cocktail("4", "Drink4", "image4")
    )

    @Test
    fun buildGame_shouldCallOnSuccess() {

        val callback = mock<CocktailGameFactory.Callback>()
        setupRepositoryWithCocktails(repository)

        factory.buildGame(callback)

        verify(callback).onSuccess(any())

    }

    private fun setupRepositoryWithCocktails(repository: Repo) {

        doAnswer {

            val callback: RepositoryCallback<List<Cocktail>, String> = it.getArgument(0)

            callback.onSuccess(cocktails)

        }.whenever(repository).getAlcoholic(any())

    }

}