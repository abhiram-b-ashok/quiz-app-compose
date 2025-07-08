package com.example.quizappcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizPage(modifier: Modifier, name: String,  navController: NavHostController){
    var questionNo by remember { mutableIntStateOf(0) }
    val question = questions[questionNo]
    var selectedOption by remember { mutableIntStateOf(-1) }
    val backStackEntry = rememberNavController().currentBackStackEntry
    val arguments = requireNotNull(backStackEntry?.arguments)
    val userName = arguments.getString("username")


    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier=modifier.background(Color(0xFF001F3F))
            .padding(16.dp)) {
            Spacer(modifier = Modifier.fillMaxHeight(0.25f))
            Text(text ="Name: $userName" , style = MaterialTheme.typography.titleSmall, color = Color(0xFFFF9800))
            Spacer(modifier = Modifier.height(16.dp))
            Text( text="Question No. ${questionNo+1}", style = MaterialTheme.typography.titleMedium, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier= Modifier.fillMaxWidth()
                .padding(12.dp)
                .border(2.dp,Color(0xFFFF9800)))
            {
                Text(text ="Q: ${question.questionText} ", color = Color.White, modifier= Modifier.padding(15.dp))
            }
            Spacer(modifier = Modifier.height(14.dp))

            question.options.forEachIndexed {  index,option ->
                val borderColor = when{
                    index== question.correctAnsIndex -> Color.Green
                    index != question.correctAnsIndex -> Color.Red
                    else -> Color.Transparent
                }
                val optionTag = when (index) {
                    0 -> "A"
                    1 -> "B"
                    2 -> "C"
                    else -> "D"
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clickable(enabled = true){selectedOption = index }
                ) {
                    Text(text = "$optionTag )  $option", color = Color.White, style = TextStyle(
                        color = borderColor,
                        drawStyle = Stroke(),
                    )
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
           when(questionNo<9){
               true ->   Button(onClick = {selectedOption = -1
                   questionNo++},
                   colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan,
                       contentColor = Color.Black,
                   ),
                   modifier = Modifier.align(Alignment.End)
               )
               {
                   Text(
                       text = "Next"
                   )
               }
               false ->  Button(onClick = {navController.navigate("result")},
                   colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan,
                       contentColor = Color.Black,
                   ),
                   modifier = Modifier.align(Alignment.End)
               )
               {
                   Text(
                       text = "Continue"
                   )
               }

           }

        }
    }
}





