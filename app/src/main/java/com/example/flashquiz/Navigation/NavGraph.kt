package com.example.flashquiz.Navigation

import androidx.collection.scatterSetOf
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flashquiz.FlashCardScreen
import com.example.flashquiz.MainActivity
import com.example.flashquiz.MainScreen
import com.example.flashquiz.MainViewModel
import com.example.flashquiz.QuizViewModel
import com.example.flashquiz.SplashScreen

@Composable
fun NavGraph(navController: NavController)
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

    composable(Screen.MainScreen.route){
    MainScreen(navController = navController, quizViewModel = QuizViewModel())
    }
        composable(Screen.FlashCardScreen.route){
            FlashCardScreen(navController = navController)
        }
        composable(Screen.MainActivity.route){
            FlashCardScreen(navController = navController)
        }
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController, mainViewModel = MainViewModel())
        }

    }
}