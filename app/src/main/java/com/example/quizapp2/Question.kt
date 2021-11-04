package com.example.quizapp2

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour:String,
    var correctAnswer: Int) {
}