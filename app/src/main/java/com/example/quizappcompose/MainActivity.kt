package com.example.quizappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizappcompose.ui.theme.QuizAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppComposeTheme {

                QuizApp(modifier = Modifier.fillMaxSize())

            }
        }
    }
}

@Composable
fun QuizApp(modifier: Modifier)
{
    var navController = rememberNavController()
    NavHost(navController= navController, startDestination = "start"){
        composable("start") {UserEntryPage(navController=navController)  }
        composable("quiz") { QuizPage(
            name = "abhi", navController = navController,
            modifier = modifier
        )}

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizAppComposeTheme {
        QuizApp(modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun QuizPagePreview() {
    QuizAppComposeTheme {
        QuizPage(modifier = Modifier.fillMaxSize().background(Color(0xFF001F3F)), "abhi", navController = rememberNavController() )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPagePreview() {
    QuizAppComposeTheme {
        ResultScreen(score = 7)
    }
}