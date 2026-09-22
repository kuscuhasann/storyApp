package com.example.masalapp.data.repository

import com.example.masalapp.data.local.StoryLocalDataSource
import com.example.masalapp.data.mapper.toDomain
import com.example.masalapp.domain.model.Story
import com.example.masalapp.domain.repository.StoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoryRepositoryImpl(
    private val localDataSource: StoryLocalDataSource
) : StoryRepository {

    override fun getStories(): Flow<List<Story>> =
        localDataSource.observeStories().map { dtos -> dtos.map { it.toDomain() } }

    override fun getStoryById(id: String): Flow<Story?> =
        localDataSource.observeStory(id).map { it?.toDomain() }
}
