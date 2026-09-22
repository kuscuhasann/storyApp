package com.example.masalapp.di

import com.example.masalapp.data.local.StoryLocalDataSource
import com.example.masalapp.data.repository.StoryRepositoryImpl
import com.example.masalapp.domain.repository.StoryRepository
import com.example.masalapp.domain.usecase.GetStoriesUseCase
import com.example.masalapp.domain.usecase.GetStoryByIdUseCase

interface AppContainer {
    val getStoriesUseCase: GetStoriesUseCase
    val getStoryByIdUseCase: GetStoryByIdUseCase
}

class DefaultAppContainer : AppContainer {
    private val storyRepository: StoryRepository = StoryRepositoryImpl(StoryLocalDataSource())

    override val getStoriesUseCase: GetStoriesUseCase = GetStoriesUseCase(storyRepository)
    override val getStoryByIdUseCase: GetStoryByIdUseCase = GetStoryByIdUseCase(storyRepository)
}
