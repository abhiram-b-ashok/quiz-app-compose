package com.example.quizappcompose


data class Question(val questionText: String,
                    val options: List<String>,
                    val correctAnsIndex: Int)

val questions = listOf(
    Question("Capital of India?", listOf("Kolkata", "Delhi", "Mumbai", "Chennai"), 1),
    Question("Prime Minister of India?", listOf("Amit Shah", "Modi", "Kejiriwal", "Rahul Gandhi"), 1),
    Question("Most populated city India? ", listOf("Kolkata", "Delhi", "Mumbai", "Bengaluru"), 2),
    Question("CM of Kerala ", listOf("Oommen Chandy", "Atchudanandan", "Pinarayi", "Sureh Gopi"), 2),
    Question("Most populated district in Kerala? ", listOf("Ernakulam", "Thiruvananthapuram", "Malappuram", "Kollam"), 3),
    Question("Which Lulu mall is biggest in Kerala? ", listOf("Kochi", "Kozhikode", "Palakkad", "Thiruvananthapuram"), 3),
    Question("Richest temple in world ", listOf("Puri", "Kashi", "Tirupati", "Padmanabhaswami temple"), 4),
    Question("Largest IT company in India", listOf("Infosys", "Wipro", "TCS", "HCL"), 3),
    Question("Capital of Andhra Pardesh ? ", listOf("Vishakapatnam", "Hyderabad", "Amaravati", "Vijayawada"), 3),
    Question("Best district in Kerala?", listOf("Kozhikode", "Kannur", "Thiruvananthapuram", "Thrissur"),1))






