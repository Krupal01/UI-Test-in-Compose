package com.example.composetesting

import android.os.IBinder
import android.view.WindowManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.Root
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.composetesting.ui.theme.ComposeTestingTheme
import org.hamcrest.TypeSafeMatcher
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

    @Test
    fun toastTest(){
        Espresso.onView(withText(TOAST_MSG)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }
}

class ToastMatcher : TypeSafeMatcher<Root?>() {

    override fun describeTo(description: org.hamcrest.Description?) {
        description?.appendText("is toast")
    }

    override fun matchesSafely(item: Root?): Boolean {
        val type: Int? = item?.windowLayoutParams?.get()?.type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken: IBinder = item.decorView.windowToken
            val appToken: IBinder = item.decorView.applicationWindowToken
            if (windowToken === appToken) {
                return true
            }
        }
        return false
    }

}