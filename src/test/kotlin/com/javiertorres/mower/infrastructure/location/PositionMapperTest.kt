package com.javiertorres.mower.infrastructure.location

import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PositionMapperTest {
    private val positionMapper = PositionMapper()
    private val position = Position(Coordinate(5, 5), Direction.W)
    private val positionString = "5 5 W"

    @Test
    fun `Given a position When mapping to a DTO Then it maps`() {
        assertEquals(PositionDTO(positionString), positionMapper.toDTO(position))
    }

    @Test
    fun `Given a string contining a position When mapping to a Position Then it maps`() {
        assertEquals(position, positionMapper.fromString(positionString))
    }
}