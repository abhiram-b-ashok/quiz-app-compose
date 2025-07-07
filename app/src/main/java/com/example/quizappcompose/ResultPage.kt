package com.example.quizappcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(score: Int) {
    val feedback = when {
        score > 8 -> "Well done."
        score > 5 -> "Congratulations"
        else -> "Failed"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001F3F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Result: $score / ${questions.size}", fontSize = 24.sp, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text(feedback, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}