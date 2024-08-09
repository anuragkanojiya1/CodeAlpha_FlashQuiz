package com.example.flashquiz

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
// import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, quizViewModel: QuizViewModel)
{


    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
    )

    var showInputScreen by remember { mutableStateOf(true) }

  //  val quizViewModel: QuizViewModel by viewModel()

    val scrollView = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(scrollView))
    {
        IconButton(modifier = Modifier
            .align(Alignment.Start),
            onClick = { navController.navigateUp() }) {
            Icon(modifier = Modifier
                .align(Alignment.Start), imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
        }

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