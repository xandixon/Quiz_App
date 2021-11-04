package com.example.quizapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvName: TextView = binding.usernameTv
        val tvScore: TextView = binding.scoreTv
        val btnFin: Button = binding.finBtn

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val corAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0).toString()
        val totAns = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0).toString()
        tvScore.text = "Your score is $corAns out of $totAns."

        btnFin.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}