package com.example.flashquiz.Navigation

sealed class Screen(val route: String) {

    object MainScreen: Screen("mainscreen")
    object FlashCardScreen: Screen("flashcardscreen")
    object MainActivity: Screen("mainactivity")
    object SplashScreen: Screen("splash")
}