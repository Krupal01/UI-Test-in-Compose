package com.example.composetesting.navigation

sealed class Screens(val route : String) {
    object mainscreen : Screens(route = "main screen")
    object secondscreen : Screens(route = "second screen")
}