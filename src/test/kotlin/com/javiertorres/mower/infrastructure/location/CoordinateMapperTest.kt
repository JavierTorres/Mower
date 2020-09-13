package com.javiertorres.mower.infrastructure.location

import com.javiertorres.mower.domain.location.Coordinate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CoordinateMapperTest {
    @Test
    fun `Given a string containing a coordinate When mapping Then returns a Coordinate`() {
        assertEquals(Coordinate(5, 5), CoordinateMapper().toCoordinate("5 5"))
    }
}