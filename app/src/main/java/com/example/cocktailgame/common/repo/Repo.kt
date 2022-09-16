package com.example.cocktailgame.common.repo

interface Repo {

    fun saveHighScore(score: Int)
    fun getHighScore(): Int
}