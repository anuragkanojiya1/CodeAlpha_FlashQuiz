package com.example.flashquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val quizData = mutableListOf<List<String>>()

    fun getQuestion(questionIndex: Int): List<String>? {
        return if (questionIndex in quizData.indices) {
            quizData[questionIndex]
        } else {
            null
        }
    }

    fun getQuizSize(): Int {
        return quizData.size
    }

    fun addQuestion(question: List<String>) {
        quizData.add(question)
    }
}
