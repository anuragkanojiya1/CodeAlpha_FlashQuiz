package com.example.flashquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun InputScreen(quizViewModel: QuizViewModel) {
    var question by remember { mutableStateOf("") }
    var option1 by remember { mutableStateOf("") }
    var option2 by remember { mutableStateOf("") }
    var option3 by remember { mutableStateOf("") }
    var option4 by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
    )

    val gradient2 = Brush.horizontalGradient(
        colors = listOf(Color(0xFFE63C3C), Color(0xFFEC1B1B))
    )

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = question,
            onValueChange = { question = it },
            label = { Text("Enter your Question") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        OutlinedTextField(
            value = option1,
            onValueChange = { option1 = it },
            label = { Text("Enter Option 1") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        OutlinedTextField(
            value = option2,
            onValueChange = { option2 = it },
            label = { Text("Enter Option 2") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        OutlinedTextField(
            value = option3,
            onValueChange = { option3 = it },
            label = { Text("Enter Option 3") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        OutlinedTextField(
            value = option4,
            onValueChange = { option4 = it },
            label = { Text("Enter Option 4") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        OutlinedTextField(
            value = answer,
            onValueChange = { answer = it },
            label = { Text("Enter the Correct Answer") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        ExtendedFloatingActionButton(
            onClick = {
                val newQuestion = listOf(question, option1, option2, option3, option4, answer)
                quizViewModel.addQuestion(newQuestion)
                question = ""
                option1 = ""
                option2 = ""
                option3 = ""
                option4 = ""
                answer = ""
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
                .background(gradient2, shape = RoundedCornerShape(0.dp))
                .height(50.dp)
        ) {
            Text("Save Question")
        }
    }
}

@Composable
fun QuizAnimation(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.quiz
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}

@Composable
fun CongoAnimation(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.congo
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}