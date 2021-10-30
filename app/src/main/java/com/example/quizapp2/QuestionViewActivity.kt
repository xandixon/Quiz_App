package com.example.quizapp2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp2.databinding.ActivityQuestionViewBinding


class QuestionViewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuestionViewBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

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
        btnSubmit = binding.btnSubmit

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        defaultOptionsView()


    }

    private fun setQuestion() {
        var cQuestion = mQuestionsList!![mCurrentPosition - 1]

        ivImage?.setImageResource(cQuestion.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = cQuestion.question
        tvOptionOne?.text = cQuestion.optionOne
        tvOptionTwo?.text = cQuestion.optionTwo
        tvOptionThree?.text = cQuestion.optionThree
        tvOptionFour?.text = cQuestion.optionFour

        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "Finish"
        }else btnSubmit?.text = "Submit"
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
//        options.add(tvOptionOne!!) //other way of doing it
        tvOptionOne?.let{options.add(0,it)}
        tvOptionTwo?.let{options.add(1,it)}
        tvOptionThree?.let{options.add(2,it)}
        tvOptionFour?.let{options.add(3,it)}

        for (option in options){
            option.setTextAppearance(R.style.text_button)
            option.setBackgroundResource(R.drawable.default_text_outline) //this is required
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}