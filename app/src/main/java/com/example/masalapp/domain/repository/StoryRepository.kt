package com.example.masalapp.domain.repository

import com.example.masalapp.domain.model.Story
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    fun getStories(): Flow<List<Story>>
    fun getStoryById(id: String): Flow<Story?>
}
