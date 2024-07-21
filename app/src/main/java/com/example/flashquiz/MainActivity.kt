package com.example.flashquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {

                    val gradient = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
                    )

                    var showInputScreen by remember { mutableStateOf(true) }
                    val quizViewModel: QuizViewModel by viewModels()

                    val scrollView = rememberScrollState()

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(scrollView))
                    {

                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .paddingFromBaseline(top = 0.dp, bottom = 0.dp),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Box {
                                QuizAnimation(
                                    modifier = Modifier
                                        //  .size(500.dp, 400.dp)
                                        .align(Alignment.TopCenter)
                                        .scale(scaleX = 1f, scaleY = 1f)
                                )
                            }
                        }

                        if (showInputScreen) {
                            InputScreen(quizViewModel = quizViewModel)
                        } else {
                            QuizScreen(quizViewModel = quizViewModel)
                        }

                        ExtendedFloatingActionButton(
                            onClick = { showInputScreen = !showInputScreen },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp)
                                .background(gradient, shape = RoundedCornerShape(0.dp))
                                .height(50.dp)
                        ) {
                            Text(if (showInputScreen) "Start Quiz" else "Add Questions")
                        }

//                        if (showInputScreen) {
//                            InputScreen(quizViewModel = quizViewModel)
//                        } else {
//                            QuizScreen(quizViewModel = quizViewModel)
//                        }
                    }
                }
            }
        }
    }
}
