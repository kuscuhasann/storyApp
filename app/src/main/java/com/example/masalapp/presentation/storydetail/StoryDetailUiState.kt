package com.example.masalapp.presentation.storydetail

import com.example.masalapp.domain.model.Story

sealed interface StoryDetailUiState {
    data object Loading : StoryDetailUiState
    data class Success(val story: Story) : StoryDetailUiState
    data object NotFound : StoryDetailUiState
}
