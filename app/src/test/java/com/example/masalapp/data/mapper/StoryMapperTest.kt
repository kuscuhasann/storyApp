package com.example.masalapp.data.mapper

import com.example.masalapp.data.model.StoryDto
import org.junit.Assert.assertEquals
import org.junit.Test

class StoryMapperTest {

    @Test
    fun `dto maps to domain story`() {
        val dto = StoryDto(
            id = "1",
            title = "Test",
            summary = "Özet",
            content = "İçerik",
            durationMinutes = 3
        )

        val story = dto.toDomain()

        assertEquals(dto.id, story.id)
        assertEquals(dto.title, story.title)
        assertEquals(dto.summary, story.summary)
        assertEquals(dto.content, story.content)
        assertEquals(dto.durationMinutes, story.durationMinutes)
    }
}
