package com.example.flashquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun QuizScreen(quizViewModel: QuizViewModel) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }

    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
    )

    val gradient2 = Brush.horizontalGradient(
        colors = listOf(Color(0xFFE63C3C), Color(0xFFEC1B1B))
    )

    val quizSize = quizViewModel.getQuizSize()

    LaunchedEffect(currentQuestionIndex) {
        if (currentQuestionIndex >= quizSize) {
            showResult = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showResult) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Your score: $score/$quizSize",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally))

                if(score == quizSize && score!=0){
                    Text(text = "Congratulations, you have Scored Full marks!!! \uD83C\uDF89\uD83E\uDD73",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        modifier = Modifier.padding(5.dp,10.dp,5.dp,10.dp))

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .paddingFromBaseline(top = 0.dp, bottom = 0.dp),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Box {
                            CongoAnimation(
                                modifier = Modifier
                                    //  .size(500.dp, 400.dp)
                                    .align(Alignment.TopCenter)
                                    .scale(scaleX = 1f, scaleY = 1f)
                            )
                        }
                    }
                }

                ExtendedFloatingActionButton(
                    onClick = {
                        currentQuestionIndex = 0
                        score = 0
                        showResult = false
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp)
                        .background(gradient2, shape = RoundedCornerShape(0.dp))
                        .height(50.dp)
                ) {
                    Text("Restart Quiz")
                }
            }
        } else {
            quizViewModel.getQuestion(currentQuestionIndex)?.let { question ->
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(question[0], fontSize = 30.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    for (i in 1..4) {
                        ExtendedFloatingActionButton(
                            onClick = {
                                if (question[i] == question[5]) {
                                    score++
                                }
                                currentQuestionIndex++
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .background(gradient2, shape = RoundedCornerShape(8.dp))
                                .height(50.dp)
                        ) {
                            Text(question[i])
                        }
                    }
                }
            } ?: run {
                Text("Loading question...")
            }

        }

    }
}