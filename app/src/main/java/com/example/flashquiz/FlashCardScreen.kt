package com.example.flashquiz

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.flashquiz.Navigation.Screen

@Composable
fun FlashCardScreen(navController: NavController) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF064CD3), Color(0xFF1E88E5))
    )

    val scrollView = rememberScrollState()

    var flashCards by remember { mutableStateOf(listOf<String>()) }

    var count by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(scrollView),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(scrollView),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(modifier = Modifier
                .padding(10.dp),
                text = "FlashQuiz",
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .size(400.dp, 200.dp),
                border = BorderStroke(5.dp, brush = gradient),
                colors = CardColors(containerColor = Color.White, contentColor = Color.Black,
                    disabledContentColor = Color.Red, disabledContainerColor = Color.Red),
                elevation = CardDefaults.outlinedCardElevation(),
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                }
            ) {
                Box(modifier = Modifier.fillMaxSize())
                {
                    Image(
                        painter = painterResource(id = R.drawable.quizphoto),
                        contentDescription = "QuizCards",
                        contentScale = ContentScale.FillWidth)

                    Text(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(10.dp),
                        text = "Flash Quiz 1",
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            flashCards.forEach { flashCard ->
                FlashCardContent(flashCard, navController = navController)
            }
        }

        ExtendedFloatingActionButton(
            modifier = Modifier.padding(10.dp),
            onClick = {
                count++
                flashCards = flashCards + "Flash Card ${count}"
            }
        ) {
            Text(text = "+ Add Quiz", fontSize = 15.sp)
        }
    }
}

@Composable
fun FlashCardContent(content: String, navController: NavController) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF064CD3), Color(0xFF1E88E5))
    )

    Card(
        modifier = Modifier
            .padding(10.dp)
            .size(400.dp, 200.dp),
        border = BorderStroke(5.dp, brush = gradient),
        colors = CardColors(containerColor = Color.White, contentColor = Color.Black,
            disabledContentColor = Color.Red, disabledContainerColor = Color.Red),
        elevation = CardDefaults.outlinedCardElevation(),
        onClick = {
            navController.navigate(Screen.MainScreen.route)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id = R.drawable.quizphoto),
            contentDescription = "QuizCards",
            contentScale = ContentScale.FillWidth)

        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp),
            text = content,
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
    }
    }
}

@Preview(showBackground = true)
@Composable
fun FlashCardScreenPreview() {
    FlashCardScreen(navController = rememberNavController())
}

























// Uses Lazy Column which have different UI behaviour

//package com.example.flashquiz
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExtendedFloatingActionButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun FlashCardScreen() {
//    val gradient = Brush.horizontalGradient(
//        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
//    )
//
//    val scrollView = rememberScrollState()
//
//    var flashCards by remember { mutableStateOf(listOf<String>()) }
//
//    Column(
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxSize()
//            .verticalScroll(scrollView)
//    ) {
//        Card(
//            modifier = Modifier
//                .padding(10.dp)
//                .size(400.dp, 200.dp)
//                .align(Alignment.CenterHorizontally),
//            border = BorderStroke(5.dp, brush = gradient),
//            elevation = CardDefaults.outlinedCardElevation()
//        ) {
//            Text(
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(10.dp),
//                text = "Flash Quiz",
//                fontSize = 30.sp
//            )
//        }
//
//        LazyColumn(modifier = Modifier.weight(1f)) {
//            items(flashCards) { flashCard ->
//                FlashCards(flashCard)
//            }
//        }
//
//        ExtendedFloatingActionButton(
//            modifier = Modifier
//                .padding(10.dp)
//                .align(Alignment.CenterHorizontally),
//            onClick = {
//                flashCards = flashCards + "New Flash Card"
//            }
//        ) {
//            Text(text = "+ Add Quiz", fontSize = 15.sp)
//        }
//    }
//}
//
//@Composable
//fun FlashCards(content: String) {
//    val gradient = Brush.horizontalGradient(
//        colors = listOf(Color(0xFF00BCD4), Color(0xFF1E88E5))
//    )
//
//    Card(
//        modifier = Modifier
//            .padding(10.dp)
//            .size(400.dp, 200.dp)
//        //    .align(Alignment.CenterHorizontally)
//        ,
//        border = BorderStroke(5.dp, brush = gradient),
//        elevation = CardDefaults.outlinedCardElevation()
//    ) {
//        Text(
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(10.dp),
//            text = content,
//            fontSize = 30.sp
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun FlashCardScreenPreview() {
//    FlashCardScreen()
//}
