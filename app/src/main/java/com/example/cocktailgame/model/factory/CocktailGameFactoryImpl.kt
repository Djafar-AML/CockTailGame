package com.example.cocktailgame.model.factory

import com.example.cocktailgame.common.network.Cocktail
import com.example.cocktailgame.common.repo.Repo
import com.example.cocktailgame.common.repo.RepositoryCallback
import com.example.cocktailgame.model.Game

class CocktailGameFactoryImpl(private val repo: Repo) : CocktailGameFactory {

    override fun buildGame(callback: CocktailGameFactory.Callback) {

        repo.getAlcoholic(object : RepositoryCallback<List<Cocktail>, String> {

            override fun onSuccess(t: List<Cocktail>) {
                callback.onSuccess(Game(emptyList()))
            }

            override fun onError(e: String) {
                callback.onError()
            }

        }
        )
    }

}