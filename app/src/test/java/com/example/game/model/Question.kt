package com.example.game.model

class Question(val correctOption: String,
               val incorrectOption: String) {

    var answeredOption = "My Answer"
        private set
}