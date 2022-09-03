package com.example.cocktailgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cocktailgame.databinding.ActivityGameBinding

class CocktailsGameActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGameBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}