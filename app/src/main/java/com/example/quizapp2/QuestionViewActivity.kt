package com.example.quizapp2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.quizapp2.databinding.ActivityQuestionViewBinding


class QuestionViewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuestionViewBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

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

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = binding.progressBar
        tvProgress = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivImage
        tvOptionOne = binding.optionOne
        tvOptionTwo = binding.optionTwo
        tvOptionThree = binding.optionThree
        tvOptionFour = binding.optionFour
        btnSubmit = binding.btnSubmit

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        defaultOptionsView()


    }

    private fun setQuestion() {
        var cQuestion = mQuestionsList!![mCurrentPosition - 1]
        defaultOptionsView()
        ivImage?.setImageResource(cQuestion.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = cQuestion.question
        tvOptionOne?.text = cQuestion.optionOne
        tvOptionTwo?.text = cQuestion.optionTwo
        tvOptionThree?.text = cQuestion.optionThree
        tvOptionFour?.text = cQuestion.optionFour


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

    private fun selectOptionView(tv: TextView, selectedOption: Int){
        mSelectedOptionPosition = selectedOption
        defaultOptionsView()
        tv.setTextAppearance(R.style.selected_text_button)
        tv.setBackgroundResource(R.drawable.selected_text_outline)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> tvOptionOne?.let{selectOptionView(it,1)}
            R.id.optionTwo -> tvOptionTwo?.let{selectOptionView(it,2)}
            R.id.optionThree -> tvOptionThree?.let{selectOptionView(it,3)}
            R.id.optionFour -> tvOptionFour?.let{selectOptionView(it,4)}
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when{mCurrentPosition<=mQuestionsList!!.size -> setQuestion()
                    else -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                        startActivity(intent)
                        finish()

                    }                    }
                    btnSubmit?.text = "Submit"
                    if(mCurrentPosition == mQuestionsList!!.size) btnSubmit?.text = "Finish"

                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) answerView(mSelectedOptionPosition,R.drawable.wrong_option_border)
                    else mCorrectAnswers++
                    answerView(question.correctAnswer,R.drawable.correct_option_border)
                    mSelectedOptionPosition = 0
                    if(mCurrentPosition < mQuestionsList!!.size) btnSubmit?.text = "Go to next question"
                }


            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int){
        when(answer){
            1 -> tvOptionOne?.setBackgroundResource(drawableView)
            2 -> tvOptionTwo?.setBackgroundResource(drawableView)
            3 -> tvOptionThree?.setBackgroundResource(drawableView)
            4 -> tvOptionFour?.setBackgroundResource(drawableView)
        }
    }
}