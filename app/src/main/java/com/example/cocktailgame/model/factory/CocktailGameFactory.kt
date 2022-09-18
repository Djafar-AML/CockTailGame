package com.example.cocktailgame.model.factory

import com.example.cocktailgame.model.Game

interface CocktailGameFactory {

    fun buildGame(callback: Callback)

    interface Callback {
        fun onSuccess(game: Game)
        fun onError()
    }
}