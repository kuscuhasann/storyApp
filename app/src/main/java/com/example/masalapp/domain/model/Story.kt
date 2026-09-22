package com.example.masalapp.domain.model

data class Story(
    val id: String,
    val title: String,
    val summary: String,
    val content: String,
    val durationMinutes: Int
)
