package com.example.quizapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp2.databinding.ActivityQuestionViewBinding

class QuestionViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)

        val questionsList = Constants.getQuestions()
    }
}