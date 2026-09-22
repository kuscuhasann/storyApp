package com.example.masalapp.data.mapper

import com.example.masalapp.data.model.StoryDto
import com.example.masalapp.domain.model.Story

fun StoryDto.toDomain(): Story = Story(
    id = id,
    title = title,
    summary = summary,
    content = content,
    durationMinutes = durationMinutes
)
