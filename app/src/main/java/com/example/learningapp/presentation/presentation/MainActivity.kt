package com.example.learningapp.presentation.presentation

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.example.learningapp.databinding.ActivityMainBinding
import com.example.learningapp.presentation.domain.models.Question

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val question=Question(quest = "nigga?", correctAnswer = "y",   firstUnCorrectAnswer = "n", secondUnCorrectAnswer = "nn", thirdUnCorrectAnswer = "nig")
        binding.bNext.setOnClickListener {
            binding.queTextView.text=question.quest
            val randomNumber = (1 .. 4).random()
            val answerList = listOf(question.correctAnswer,question.firstUnCorrectAnswer,question.secondUnCorrectAnswer,question.thirdUnCorrectAnswer)
           when(randomNumber){
               1 ->{binding.bFirstAnswer.text=answerList[0];binding.bSecondAnswer.text=answerList[1];binding.bThirdAnswer.text=answerList[2];binding.bFourthAnswer.text=answerList[3]}
               2->{binding.bFirstAnswer.text=answerList[1];binding.bSecondAnswer.text=answerList[2];binding.bThirdAnswer.text=answerList[3];binding.bFourthAnswer.text=answerList[0]}
               3->{binding.bFirstAnswer.text=answerList[2];binding.bSecondAnswer.text=answerList[3];binding.bThirdAnswer.text=answerList[0];binding.bFourthAnswer.text=answerList[1]}
               4->{binding.bFirstAnswer.text=answerList[3];binding.bSecondAnswer.text=answerList[0];binding.bThirdAnswer.text=answerList[1];binding.bFourthAnswer.text=answerList[2]}
               else ->finish()
           }
            binding.bFirstAnswer.setOnClickListener { if(binding.bFirstAnswer.text==question.correctAnswer) Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show() else Toast.makeText(this, "unCorrect", Toast.LENGTH_SHORT).show()}
            binding.bSecondAnswer.setOnClickListener { if(binding.bSecondAnswer.text==question.correctAnswer) Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show() else Toast.makeText(this, "unCorrect", Toast.LENGTH_SHORT).show()}
            binding.bThirdAnswer.setOnClickListener { if(binding.bThirdAnswer.text==question.correctAnswer) Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show() else Toast.makeText(this, "unCorrect", Toast.LENGTH_SHORT).show()}
            binding.bFourthAnswer.setOnClickListener { if(binding.bFourthAnswer.text==question.correctAnswer) Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show() else Toast.makeText(this, "unCorrect", Toast.LENGTH_SHORT).show()}

        }

    }
}

