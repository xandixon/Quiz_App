package com.example.quizapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp2.databinding.ActivityQuestionViewBinding


class QuestionViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionViewBinding
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)
        binding = ActivityQuestionViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar
        tvProgress = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivImage

        val questionsList = Constants.getQuestions()
        Log.i("QuestionList size is","${questionsList.size}")
    }
}