package com.example.composetesting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.composetesting.ui.theme.ComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val mainScreenRule = createComposeRule()

    @Before
    fun setUp(){
        mainScreenRule.setContent {
            ComposeTestingTheme {
                MainScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    @Test
    fun mainScreenTestCase(){
        val mainColumn = mainScreenRule.onNodeWithTag(TEST_TAG_COLUMN)
        val loginLabel = mainScreenRule.onNodeWithTag(TEST_TAG_LOGIN_LABEL)
        val username = mainScreenRule.onNodeWithTag(TEST_TAG_USERNAME)
        val password = mainScreenRule.onNodeWithTag(TEST_TAG_PASSWORD)
        val submitBtn = mainScreenRule.onNodeWithTag(TEST_TAG_SUBMIT)

        mainColumn.assertIsDisplayed()
        loginLabel.assertIsDisplayed()
        username.assertIsDisplayed()
        password.assertIsDisplayed()
        submitBtn.assertIsDisplayed()

        username.performTextInput("username")
        password.performTextInput("password")
        submitBtn.performClick()

    }
}
