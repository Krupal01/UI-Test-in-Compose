package com.example.composetesting

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetesting.navigation.MainNavHost
import com.example.composetesting.navigation.Screens
import com.example.composetesting.ui.theme.ComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainNavHostTest {

    private lateinit var navController: NavHostController
    @get:Rule
    val navRule = createComposeRule()

    @Before
    fun setUp(){
        navRule.setContent {
            ComposeTestingTheme {
                navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.mainscreen.route ){
                    composable(route = Screens.mainscreen.route){
                        MainScreen(navigateTo = { route ->  navController.navigate(route)})
                    }
                    composable(route = Screens.secondscreen.route){
                        SecondScreen()
                    }
                }
            }
        }
    }

    @Test
    fun navHostTest(){
        navRule.onNodeWithTag(TEST_TAG_SUBMIT).performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        assert(route.equals(Screens.secondscreen.route))
    }
}