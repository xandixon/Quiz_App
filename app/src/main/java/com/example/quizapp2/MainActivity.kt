package com.example.quizapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etBtn.setOnClickListener {
            if(binding.nameField.text.toString().isEmpty()){
                Toast.makeText(this,"You didn't fucken follow instructions",Toast.LENGTH_SHORT).show()
            }
        }


    }



}