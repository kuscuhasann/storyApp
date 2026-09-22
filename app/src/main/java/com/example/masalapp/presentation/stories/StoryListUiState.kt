package com.example.masalapp.presentation.stories

import com.example.masalapp.domain.model.Story

sealed interface StoryListUiState {
    data object Loading : StoryListUiState
    data class Success(val stories: List<Story>) : StoryListUiState
    data object Empty : StoryListUiState
}
