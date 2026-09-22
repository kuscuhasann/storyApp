package com.example.masalapp.domain.usecase

import com.example.masalapp.domain.model.Story
import com.example.masalapp.domain.repository.StoryRepository
import kotlinx.coroutines.flow.Flow

class GetStoryByIdUseCase(
    private val storyRepository: StoryRepository
) {
    operator fun invoke(id: String): Flow<Story?> = storyRepository.getStoryById(id)
}
