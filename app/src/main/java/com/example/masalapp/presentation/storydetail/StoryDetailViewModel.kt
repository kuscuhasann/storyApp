package com.example.masalapp.presentation.storydetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.masalapp.domain.usecase.GetStoryByIdUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class StoryDetailViewModel(
    storyId: String,
    getStoryByIdUseCase: GetStoryByIdUseCase
) : ViewModel() {

    val uiState: StateFlow<StoryDetailUiState> = getStoryByIdUseCase(storyId)
        .map { story ->
            if (story == null) StoryDetailUiState.NotFound else StoryDetailUiState.Success(story)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = StoryDetailUiState.Loading
        )

    companion object {
        fun factory(
            storyId: String,
            getStoryByIdUseCase: GetStoryByIdUseCase
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return StoryDetailViewModel(storyId, getStoryByIdUseCase) as T
            }
        }
    }
}
