package com.example.composetesting

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetesting.navigation.MainNavHost
import com.example.composetesting.navigation.Screens
import com.example.composetesting.ui.theme.ComposeTestingTheme

const val TEST_TAG_COLUMN = "TEST TAG COLUMN"
const val TEST_TAG_LOGIN_LABEL = "TEST TAG LOGIN_LABEL"
const val TEST_TAG_USERNAME = "TEST TAG USERNAME"
const val TEST_TAG_PASSWORD = "TEST TAG PASSWORD"
const val TEST_TAG_SUBMIT = "TEST TAG SUBMIT"
const val TOAST_MSG = "Clicked"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                MainNavHost()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",Modifier.testTag("text"))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestingTheme {
        Greeting("Android")
    }
}

@Composable
fun MainScreen(
    modifier : Modifier = Modifier,
    navigateTo : (route : String)->Unit
) {

    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag(TEST_TAG_COLUMN),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login Form", modifier = Modifier.testTag(TEST_TAG_LOGIN_LABEL))
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TEST_TAG_USERNAME)
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TEST_TAG_PASSWORD)
        )
        Button(
            onClick = {
                Toast.makeText(context, TOAST_MSG,Toast.LENGTH_LONG).show()
                navigateTo(Screens.secondscreen.route)
            },
            modifier = Modifier.testTag(TEST_TAG_SUBMIT)
        ) {
            Text(text = "Submit")
        }

    }
}

@Composable
fun SecondScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2")
    }
}