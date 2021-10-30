package com.example.quizapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp2.databinding.ActivityQuestionViewBinding
//

class QuestionViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionViewBinding
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)
        binding = ActivityQuestionViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar
        tvProgress = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivImage
        tvOptionOne = binding.optionOne
        tvOptionTwo = binding.optionTwo
        tvOptionThree = binding.optionThree
        tvOptionFour = binding.optionFour


        val questionsList = Constants.getQuestions()
        Log.i("QuestionList size is","${questionsList.size}")
        var currentPosition = 1
        var cQuestion = questionsList[currentPosition -1]

        ivImage?.setImageResource(cQuestion.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = cQuestion.question
        tvOptionOne?.text = cQuestion.optionOne
        tvOptionTwo?.text = cQuestion.optionTwo
        tvOptionThree?.text = cQuestion.optionThree
        tvOptionFour?.text = cQuestion.optionFour


    }
}