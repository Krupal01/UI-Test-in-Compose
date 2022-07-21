package com.example.composetesting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.composetesting.ui.theme.ComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GreetingTest {

    @get:Rule
    val greetingRule = createComposeRule()

    @Before
    fun setUp(){
        greetingRule.setContent {
            ComposeTestingTheme {
                    Greeting("Android")
            }
        }
    }

    @Test
    fun greetingTestCase(){
        val text = greetingRule.onNodeWithTag("text")
        text.assertIsDisplayed()
    }

}