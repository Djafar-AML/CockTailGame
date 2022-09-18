package com.example.cocktailgame.common.repo

import com.example.cocktailgame.common.network.Cocktail

interface Repo {

    fun saveHighScore(score: Int)
    fun getHighScore(): Int
    fun getAlcoholic(callback: RepositoryCallback<List<Cocktail>, String>)

}

interface RepositoryCallback<T, E> {

    fun onSuccess(t: T)
    fun onError(e: E)

}