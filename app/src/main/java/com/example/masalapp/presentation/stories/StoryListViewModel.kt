package com.example.masalapp.presentation.stories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.masalapp.domain.usecase.GetStoriesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class StoryListViewModel(
    getStoriesUseCase: GetStoriesUseCase
) : ViewModel() {

    val uiState: StateFlow<StoryListUiState> = getStoriesUseCase()
        .map { stories ->
            if (stories.isEmpty()) StoryListUiState.Empty else StoryListUiState.Success(stories)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = StoryListUiState.Loading
        )

    companion object {
        fun factory(getStoriesUseCase: GetStoriesUseCase): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return StoryListViewModel(getStoriesUseCase) as T
                }
            }
    }
}
