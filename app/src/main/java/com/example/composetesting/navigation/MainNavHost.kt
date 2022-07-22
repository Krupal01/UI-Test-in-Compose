package com.example.composetesting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetesting.MainScreen
import com.example.composetesting.SecondScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.mainscreen.route){
        composable(route = Screens.mainscreen.route){
            MainScreen(navigateTo = { route ->  navController.navigate(route)})
        }
        composable(route = Screens.secondscreen.route){
            SecondScreen()
        }
    }
}