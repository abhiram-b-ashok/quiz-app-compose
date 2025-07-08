package com.example.quizappcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun UserEntryPage(modifier: Modifier= Modifier, navController: NavHostController)
{
    var userName by rememberSaveable { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color(0xFF001F3F))
            .fillMaxSize()) {
        Text(
            text = " Enter your name", color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value =userName ,
            onValueChange = { userName = it },
            placeholder = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate("quiz/{username}".replace(oldValue = "{username}", newValue = userName))},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan, contentColor = Color.Black)
            )
        {
            Text(
                text = "Start Quiz"
            )
        }


    }
}