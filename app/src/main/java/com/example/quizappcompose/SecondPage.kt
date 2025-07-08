package com.example.quizappcompose


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizappcompose.ui.theme.CustomShape
import kotlinx.coroutines.delay
import kotlin.math.ceil

@Composable
fun QuizPage(modifier: Modifier, name: String,  navController: NavHostController){
    var questionNo by remember { mutableIntStateOf(0) }
    var question = questions[questionNo]
    var selectedOption by remember { mutableIntStateOf(-1) }
    var score by remember { mutableIntStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }
    var enableNext by remember { mutableStateOf(false) }

    LaunchedEffect(selectedOption) {
        if (selectedOption!= -1 && !showAnswer){
            delay(2000)
            showAnswer = true
            enableNext = true
            if(selectedOption==question.correctAnsIndex){
                score++
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier=modifier.background(Color(0xFF001F3F))
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Text(text ="Name: $name" , style = MaterialTheme.typography.titleLarge, color = Color(0xFFFF9800))
            Spacer(modifier = Modifier.height(76.dp))
            Text( text="Question No. ${questionNo+1}", style = MaterialTheme.typography.titleMedium, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

Box(modifier = Modifier.fillMaxWidth().background(shape = CustomShape(), color = Color(0xFFFF9800)).padding(3.dp))
{
    Box(modifier= Modifier.fillMaxWidth()
        .background(shape = CustomShape(), color =Color(0xFF001F3F))
    )
    {
        Row( verticalAlignment = Alignment.CenterVertically ) {
            Text(text ="  Q:", color = Color.White, modifier= Modifier.padding(15.dp))

            Text(text = question.questionText, color = Color.White, maxLines = 2,
                overflow = TextOverflow.Ellipsis, modifier= Modifier.padding(15.dp))
        }

    }

}



            Spacer(modifier = Modifier.height(14.dp))

            question.options.forEachIndexed {  index,option ->
                val borderColor = when{
                    showAnswer && index== question.correctAnsIndex -> Color.Green
                    showAnswer && index == selectedOption&& index!=question.correctAnsIndex -> Color.Red
                    selectedOption==index -> Color(0xFFFF5722)
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
                        Text(
                            text = "${optionTag}) $option ",
                            color = Color.White,
                            modifier = Modifier.border(width= 2.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
                                .padding(10.dp)
                        )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
           when(questionNo<9){
               true ->   Button(onClick = {selectedOption = -1
                   questionNo++
                   enableNext=false
                   showAnswer=false},
                   modifier = Modifier.align(Alignment.End),
                   enabled = enableNext,
                   colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan,
                       contentColor = Color.Black),
               )
               {
                   Text(
                       text = "Next"
                   )
               }
               false ->  Button(onClick = {navController.navigate("result/$score")},
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





